package com.dao;
import java.sql.*;
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {
    private String url = "jdbc:mysql://localhost:3306/MarkWebAppDB";
    private String user = "root";
    private String pass = "password"; 

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // THIS IS YOUR "ADD" METHOD
    public void insertMark(StudentMark sm) throws Exception {
        try (Connection con = getConnection(); 
             PreparedStatement ps = con.prepareStatement("INSERT INTO StudentMarks VALUES(?,?,?,?,?)")) {
            ps.setInt(1, sm.getStudentID());
            ps.setString(2, sm.getStudentName());
            ps.setString(3, sm.getSubject());
            ps.setInt(4, sm.getMarks());
            ps.setString(5, sm.getExamDate());
            ps.executeUpdate();
        }
    }

    public void updateMark(StudentMark sm) throws Exception {
        try (Connection con = getConnection(); 
             PreparedStatement ps = con.prepareStatement("UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?")) {
            ps.setString(1, sm.getStudentName());
            ps.setString(2, sm.getSubject());
            ps.setInt(3, sm.getMarks());
            ps.setString(4, sm.getExamDate());
            ps.setInt(5, sm.getStudentID());
            ps.executeUpdate();
        }
    }

    public void deleteMark(int id) throws Exception {
        try (Connection con = getConnection(); 
             PreparedStatement ps = con.prepareStatement("DELETE FROM StudentMarks WHERE StudentID=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<StudentMark> getAllMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM StudentMarks")) {
            while (rs.next()) {
                list.add(new StudentMark(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        }
        return list;
    }
}