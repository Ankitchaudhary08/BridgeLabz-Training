// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {

    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory = "";

    // Constructor
    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Encapsulation for medical history
    protected void appendMedicalHistory(String record) {
        medicalHistory += record + "\n";
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Total Bill: " + calculateBill());
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double roomChargePerDay;
    private double medicineCost;

    public InPatient(int id, String name, int age, String diagnosis,
                     int days, double roomCharge, double medicineCost) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = days;
        this.roomChargePerDay = roomCharge;
        this.medicineCost = medicineCost;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * roomChargePerDay) + medicineCost;
    }

    @Override
    public void addRecord(String record) {
        appendMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:\n" + getMedicalHistory());
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, String diagnosis,
                      double consultationFee) {
        super(id, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        appendMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:\n" + getMedicalHistory());
    }
}

// Main class
public class HospitalPatientManagement {

    public static void main(String[] args) {

        Patient p1 = new InPatient(
                101, "Ankit", 22, "Fever",
                3, 2000, 1500
        );

        Patient p2 = new OutPatient(
                102, "Rahul", 30, "Checkup",
                500
        );

        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            p.getPatientDetails();

            MedicalRecord mr = (MedicalRecord) p;
            mr.addRecord("Visited doctor");
            mr.viewRecords();

            System.out.println("----------------------");
        }
    }
}
