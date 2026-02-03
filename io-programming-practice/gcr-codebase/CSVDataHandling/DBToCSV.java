import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

public class DBToCSV {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";

        String query = "SELECT id, name, department, salary FROM employee";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"))
        ) {

            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                bw.write(
                    rs.getInt("id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getDouble("salary")
                );
                bw.newLine();
            }

            System.out.println("CSV report generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
