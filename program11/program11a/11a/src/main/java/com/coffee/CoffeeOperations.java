package com.coffee;
import java.sql.*;

public class CoffeeOperations {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password"; // Update this!

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!\n");

            // READ records with perfect alignment
            String selectSql = "SELECT * FROM coffee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);

            // Using printf for the header
            System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Price");
            System.out.println("--------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("coffee_name");
                int price = rs.getInt("price");
                
                // %-20s ensures the name always takes up 20 characters of space
                System.out.printf("%-10d %-20s %-10d%n", id, name, price);
            }

            // INSERT new record
            String insertSql = "INSERT INTO coffee (coffee_name, price) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, "Arabica"); 
            pstmt.setInt(2, 200);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nSuccessfully inserted a new coffee product!");
            }

            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}