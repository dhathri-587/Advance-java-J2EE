package com.coffee;

import java.sql.*;

public class CoffeeSearch {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password"; // Update this with your actual password

        try {
            // Load the driver to ensure it's registered
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // SQL Query: Searching for names starting with 'D'
            String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("--- Coffee Products Starting with 'D' ---");
            System.out.printf("%-10s %-20s %-10s%n", "ID", "Coffee Name", "Price");
            System.out.println("------------------------------------------");

            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("coffee_name");
                int price = rs.getInt("price");
                System.out.printf("%-10d %-20s %-10d%n", id, name, price);
            }

            if (!found) {
                System.out.println("No records found starting with 'D'.");
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}