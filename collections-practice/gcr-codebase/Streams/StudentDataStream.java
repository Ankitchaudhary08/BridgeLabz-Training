import java.io.*;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "student.dat";

        // Writing data to file
        try (
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream(fileName))
        ) {
            int rollNo = 101;
            String name = "Ankit";
            double gpa = 8.5;

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
        }

        // Reading data from file
        try (
            DataInputStream dis = new DataInputStream(
                    new FileInputStream(fileName))
        ) {
            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Details:");
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name   : " + name);
            System.out.println("GPA    : " + gpa);

        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }
    }
}
