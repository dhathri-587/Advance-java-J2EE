package com.model;

public class StudentMark {
    private int studentID;
    private String studentName;
    private String subject;
    private int marks;
    private String examDate;

    public StudentMark(int studentID, String studentName, String subject, int marks, String examDate) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subject = subject;
        this.marks = marks;
        this.examDate = examDate;
    }

    public int getStudentID() { return studentID; }
    public String getStudentName() { return studentName; }
    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
    public String getExamDate() { return examDate; }
}