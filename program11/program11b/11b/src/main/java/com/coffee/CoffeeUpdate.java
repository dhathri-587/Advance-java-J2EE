package com.coffee;

import java.sql.*;

public class CoffeeUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password"; // Update this!

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!\n");

            // 1. Display Current Records
            String selectSql = "SELECT * FROM coffee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);

            System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Price");
            System.out.println("--------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-10d %-20s %-10d%n", 
                    rs.getInt("id"), rs.getString("coffee_name"), rs.getInt("price"));
            }

            // 2. Perform the Update
            String updateSql = "UPDATE coffee SET price = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSql);
            
            pstmt.setInt(1, 160); // Set new price
            pstmt.setInt(2, 102); // Target ID 102

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("\nSuccessfully updated coffee record with ID 102!");
            }

            // Cleanup
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}