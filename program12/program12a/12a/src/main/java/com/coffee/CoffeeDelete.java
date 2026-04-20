package com.coffee;
import java.sql.*;

public class CoffeeDelete {
    public static void main(String[] args) {
        // 1. UPDATE YOUR CREDENTIALS HERE
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String pass = "password"; 

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            // 2. SHOW BEFORE
            System.out.println("--- Table Before Delete ---");
            printTable(conn);

            // 3. RUN DELETE
            PreparedStatement ps = conn.prepareStatement("DELETE FROM coffee WHERE id = ?");
            ps.setInt(1, 105); // Make sure 103 exists!
            int result = ps.executeUpdate();
            
            if(result > 0) System.out.println("\nSUCCESS: Record Deleted.\n");
            else System.out.println("\nFAILED: No record found with that ID.\n");

            // 4. SHOW AFTER
            System.out.println("--- Table After Delete ---");
            printTable(conn);

            conn.close();
        } catch (Exception e) {
            System.out.println("DATABASE ERROR: " + e.getMessage());
        }
    }

    public static void printTable(Connection conn) throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM coffee");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Price");
        while (rs.next()) {
            System.out.printf("%-10d %-20s %-10d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
    }
}