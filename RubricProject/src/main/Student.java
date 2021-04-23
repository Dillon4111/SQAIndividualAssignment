package main;

import java.util.ArrayList;

public class Student {

    private String studentName;
    private ArrayList<Topic> topics = new ArrayList<>();

    public Student() {
    }

    public Student(String studentName, ArrayList<Topic> topics) {
        this.studentName = studentName;
        this.topics = topics;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
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
