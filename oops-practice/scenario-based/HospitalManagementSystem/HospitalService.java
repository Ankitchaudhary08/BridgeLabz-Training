package HospitalManagementSystem;

public interface HospitalService {

    void addPatient(Patient patient);
    void addDoctor(Doctor doctor);

    void bookAppointment(Appointment appointment)
            throws AppointmentNotAvailableException;

    void cancelAppointment(Appointment appointment);
}

