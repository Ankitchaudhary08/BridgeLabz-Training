package HospitalManagementSystem;

public class Doctor extends Person {

    private int doctorId;
    private String specialization;

    public Doctor(int doctorId, String name, int age, String specialization) {
        super(name, age);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    // Polymorphism
    public double calculateConsultationFee() {
        return 500; // default fee
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }
}
