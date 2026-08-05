package com.clinic.ui;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.AppointmentDAOImpl;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.BillingDAOImpl;
import com.clinic.dao.DoctorDAO;
import com.clinic.dao.DoctorDAOImpl;
import com.clinic.dao.PatientDAO;
import com.clinic.dao.PatientDAOImpl;
import com.clinic.dao.SpecializationDAO;
import com.clinic.dao.SpecializationDAOImpl;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dao.VisitHistoryDAOImpl;
import com.clinic.dto.Appointment;
import com.clinic.dto.Billing;
import com.clinic.dto.Doctor;
import com.clinic.dto.Patient;
import com.clinic.dto.Specialization;
import com.clinic.dto.VisitHistory;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final Scanner scanner = new Scanner(System.in);
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Choose option: ");
            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> specializationMenu();
                case 4 -> appointmentMenu();
                case 5 -> billingMenu();
                case 6 -> visitHistoryMenu();
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("===== Health Clinic App =====");
        System.out.println("1. Patients");
        System.out.println("2. Doctors");
        System.out.println("3. Specializations");
        System.out.println("4. Appointments");
        System.out.println("5. Billing");
        System.out.println("6. Visit History");
        System.out.println("0. Exit");
    }

    private void patientMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patients ---");
            System.out.println("1. Register  2. List  3. View  4. Update  5. Delete  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> createPatient();
                case 2 -> printList(patientDAO.findAll());
                case 3 -> System.out.println(valueOrMissing(patientDAO.findById(readInt("Patient ID: "))));
                case 4 -> updatePatient();
                case 5 -> printResult(patientDAO.delete(readInt("Patient ID: ")), "Patient deleted.");
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void doctorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Doctors ---");
            System.out.println("1. Register  2. List  3. View  4. Update  5. Delete  6. Assign Specialization  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> createDoctor();
                case 2 -> printList(doctorDAO.findAll());
                case 3 -> System.out.println(valueOrMissing(doctorDAO.findById(readInt("Doctor ID: "))));
                case 4 -> updateDoctor();
                case 5 -> printResult(doctorDAO.delete(readInt("Doctor ID: ")), "Doctor deleted.");
                case 6 -> assignSpecialization();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void specializationMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Specializations ---");
            System.out.println("1. Add  2. List  3. View  4. Update  5. Delete  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> createSpecialization();
                case 2 -> printList(specializationDAO.findAll());
                case 3 -> System.out.println(valueOrMissing(specializationDAO.findById(readInt("Specialization ID: "))));
                case 4 -> updateSpecialization();
                case 5 -> printResult(specializationDAO.delete(readInt("Specialization ID: ")), "Specialization deleted.");
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void appointmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Appointments ---");
            System.out.println("1. Book  2. List  3. View  4. Update  5. Cancel  6. Complete  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> createAppointment();
                case 2 -> printList(appointmentDAO.findAll());
                case 3 -> System.out.println(valueOrMissing(appointmentDAO.findById(readInt("Appointment ID: "))));
                case 4 -> updateAppointment();
                case 5 -> printResult(appointmentDAO.updateStatus(readInt("Appointment ID: "), "Cancelled"), "Appointment cancelled.");
                case 6 -> completeAppointment();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void billingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Billing ---");
            System.out.println("1. List  2. View Bill  3. View By Appointment  4. Update Payment  5. Delete  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> printList(billingDAO.findAll());
                case 2 -> System.out.println(valueOrMissing(billingDAO.findById(readInt("Bill ID: "))));
                case 3 -> System.out.println(valueOrMissing(billingDAO.findByAppointmentId(readInt("Appointment ID: "))));
                case 4 -> updateBilling();
                case 5 -> printResult(billingDAO.delete(readInt("Bill ID: ")), "Bill deleted.");
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void visitHistoryMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Visit History ---");
            System.out.println("1. List  2. View Visit  3. View By Appointment  4. Update  5. Delete  0. Back");
            switch (readInt("Choose option: ")) {
                case 1 -> printList(visitHistoryDAO.findAll());
                case 2 -> System.out.println(valueOrMissing(visitHistoryDAO.findById(readInt("Visit ID: "))));
                case 3 -> System.out.println(valueOrMissing(visitHistoryDAO.findByAppointmentId(readInt("Appointment ID: "))));
                case 4 -> updateVisitHistory();
                case 5 -> printResult(visitHistoryDAO.delete(readInt("Visit ID: ")), "Visit history deleted.");
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void createPatient() {
        Patient patient = readPatient(false);
        int id = patientDAO.create(patient);
        printCreated(id, "Patient");
    }

    private void updatePatient() {
        Patient patient = readPatient(true);
        printResult(patientDAO.update(patient), "Patient updated.");
    }

    private Patient readPatient(boolean includeId) {
        Patient patient = new Patient();
        if (includeId) {
            patient.setPatientId(readInt("Patient ID: "));
        }
        patient.setFirstName(readText("First name: "));
        patient.setLastName(readText("Last name: "));
        patient.setDateOfBirth(readDate("Date of birth (yyyy-MM-dd, blank allowed): "));
        patient.setGender(readEnum("Gender (Male/Female/Other): ", "Male", "Female", "Other"));
        patient.setEmail(readText("Email: "));
        return patient;
    }

    private void createDoctor() {
        Doctor doctor = readDoctor(false);
        int id = doctorDAO.create(doctor);
        printCreated(id, "Doctor");
    }

    private void updateDoctor() {
        Doctor doctor = readDoctor(true);
        printResult(doctorDAO.update(doctor), "Doctor updated.");
    }

    private Doctor readDoctor(boolean includeId) {
        Doctor doctor = new Doctor();
        if (includeId) {
            doctor.setDoctorId(readInt("Doctor ID: "));
        }
        doctor.setFirstName(readText("First name: "));
        doctor.setLastName(readText("Last name: "));
        doctor.setPhoneNumber(readText("Phone number: "));
        doctor.setEmail(readText("Email: "));
        return doctor;
    }

    private void assignSpecialization() {
        int doctorId = readInt("Doctor ID: ");
        int specializationId = readInt("Specialization ID: ");
        printResult(doctorDAO.assignSpecialization(doctorId, specializationId), "Specialization assigned.");
    }

    private void createSpecialization() {
        Specialization specialization = readSpecialization(false);
        int id = specializationDAO.create(specialization);
        printCreated(id, "Specialization");
    }

    private void updateSpecialization() {
        Specialization specialization = readSpecialization(true);
        printResult(specializationDAO.update(specialization), "Specialization updated.");
    }

    private Specialization readSpecialization(boolean includeId) {
        Specialization specialization = new Specialization();
        if (includeId) {
            specialization.setSpecializationId(readInt("Specialization ID: "));
        }
        specialization.setName(readText("Name: "));
        specialization.setDescription(readText("Description: "));
        return specialization;
    }

    private void createAppointment() {
        Appointment appointment = readAppointment(false);
        int id = appointmentDAO.create(appointment);
        printCreated(id, "Appointment");
    }

    private void updateAppointment() {
        Appointment appointment = readAppointment(true);
        printResult(appointmentDAO.update(appointment), "Appointment updated.");
    }

    private Appointment readAppointment(boolean includeId) {
        Appointment appointment = new Appointment();
        if (includeId) {
            appointment.setAppointmentId(readInt("Appointment ID: "));
        }
        appointment.setPatientId(readInt("Patient ID: "));
        appointment.setDoctorId(readInt("Doctor ID: "));
        appointment.setAppointmentDate(readDateTime("Appointment date (yyyy-MM-dd HH:mm): "));
        appointment.setStatus(readEnum("Status (Scheduled/Completed/Cancelled): ", "Scheduled", "Completed", "Cancelled"));
        return appointment;
    }

    private void completeAppointment() {
        int appointmentId = readInt("Appointment ID: ");
        BigDecimal amount = readMoney("Bill amount: ");
        String diagnosis = readText("Diagnosis: ");
        String prescription = readText("Prescription: ");
        String notes = readText("Visit notes: ");
        printResult(
                appointmentService.completeAppointment(appointmentId, amount, diagnosis, prescription, notes),
                "Appointment completed with bill and visit history."
        );
    }

    private void updateBilling() {
        Billing billing = billingDAO.findById(readInt("Bill ID: "));
        if (billing == null) {
            System.out.println("No record found.");
            return;
        }
        billing.setAmount(readMoney("Amount: "));
        billing.setPaymentStatus(readEnum("Payment status (Pending/Paid/Refunded): ", "Pending", "Paid", "Refunded"));
        printResult(billingDAO.update(billing), "Bill updated.");
    }

    private void updateVisitHistory() {
        VisitHistory visitHistory = visitHistoryDAO.findById(readInt("Visit ID: "));
        if (visitHistory == null) {
            System.out.println("No record found.");
            return;
        }
        visitHistory.setDiagnosis(readText("Diagnosis: "));
        visitHistory.setPrescription(readText("Prescription: "));
        visitHistory.setVisitNotes(readText("Visit notes: "));
        printResult(visitHistoryDAO.update(visitHistory), "Visit history updated.");
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    private BigDecimal readMoney(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid amount.");
            }
        }
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            String input = readText(prompt);
            if (input.isBlank()) {
                return null;
            }
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Use yyyy-MM-dd format.");
            }
        }
    }

    private LocalDateTime readDateTime(String prompt) {
        while (true) {
            String input = readText(prompt);
            try {
                return LocalDateTime.parse(input, DATE_TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Use yyyy-MM-dd HH:mm format.");
            }
        }
    }

    private String readEnum(String prompt, String... allowed) {
        while (true) {
            String input = readText(prompt);
            for (String value : allowed) {
                if (value.equalsIgnoreCase(input)) {
                    return value;
                }
            }
            System.out.println("Allowed values: " + String.join(", ", allowed));
        }
    }

    private void printCreated(int id, String label) {
        if (id > 0) {
            System.out.println(label + " created with ID: " + id);
        } else {
            System.out.println(label + " was not created.");
        }
    }

    private void printResult(boolean success, String successMessage) {
        System.out.println(success ? successMessage : "Operation failed.");
    }

    private void printList(List<?> items) {
        if (items.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        items.forEach(System.out::println);
    }

    private String valueOrMissing(Object value) {
        return value == null ? "No record found." : value.toString();
    }
}
