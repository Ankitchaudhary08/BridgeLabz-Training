package HospitalManagementSystem;

public class Main {

    public static void main(String[] args) {

        HospitalService hospital = new HospitalServiceImpl();

        Patient p1 = new Patient(1, "Ankit", 21);
        Doctor d1 = new Doctor(101, "Dr. Sharma", 45, "Cardiologist");

        hospital.addPatient(p1);
        hospital.addDoctor(d1);

        Appointment ap1 = new Appointment(p1, d1, "10-02-2026");

        try {
            hospital.bookAppointment(ap1);
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.addMedicalRecord("Blood Pressure Normal");
        p1.addMedicalRecord("ECG Clear");

        p1.viewMedicalHistory();

        System.out.println("Consultation Fee: ₹" +
                d1.calculateConsultationFee());
    }
}
