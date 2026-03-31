package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.name);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.getName());
    }

    @Override
    public void bookAppointment(Appointment appointment)
            throws AppointmentNotAvailableException {

        if (appointments.size() >= 3) {
            throw new AppointmentNotAvailableException(
                    "No appointment slots available"
            );
        }

        appointments.add(appointment);
        System.out.println("Appointment booked: " + appointment.getDetails());
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("Appointment cancelled");
    }
}

