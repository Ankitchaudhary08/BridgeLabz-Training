package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

    private int patientId;
    private List<String> medicalHistory;

    public Patient(int patientId, String name, int age) {
        super(name, age);
        this.patientId = patientId;
        this.medicalHistory = new ArrayList<>();
    }

    public int getPatientId() {
        return patientId;
    }

    public void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewMedicalHistory() {
        System.out.println("Medical History of " + name + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}
