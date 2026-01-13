package HospitalManagementSystem;
public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public String getDetails() {
        return "Appointment on " + date +
               " | Doctor: " + doctor.getName() +
               " | Patient: " + patient.name;
    }
}
