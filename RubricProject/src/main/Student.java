package main;

import java.util.ArrayList;

public class Student {

    private String studentName;
    private ArrayList<String> topics = new ArrayList<String>();

    public Student() {
    }

    public Student(String studentName, ArrayList<String> topics) {
        this.studentName = studentName;
        this.topics = topics;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", topics=" + topics +
                '}';
    }
}
