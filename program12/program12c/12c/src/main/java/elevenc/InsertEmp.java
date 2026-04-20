package elevenc;

import java.sql.*;

public class InsertEmp {
    public static void main(String[] args) {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Employee", "root", "password");

            // Insert Query
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Emp VALUES (?, ?, ?)");

            // Record 1
            ps.setInt(1, 101);
            ps.setString(2, "Ramesh");
            ps.setInt(3, 25000);
            ps.executeUpdate();

            // Record 2
            ps.setInt(1, 102);
            ps.setString(2, "Ravi");
            ps.setInt(3, 20000);
            ps.executeUpdate();

            // Record 3
            ps.setInt(1, 103);
            ps.setString(2, "Anil");
            ps.setInt(3, 18000);
            ps.executeUpdate();

            // Record 4
            ps.setInt(1, 104);
            ps.setString(2, "Raj");
            ps.setInt(3, 30000);
            ps.executeUpdate();

            // Record 5
            ps.setInt(1, 105);
            ps.setString(2, "Suresh");
            ps.setInt(3, 22000);
            ps.executeUpdate();

            System.out.println("Records Inserted Successfully!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}