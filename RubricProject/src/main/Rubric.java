package main;

import java.util.ArrayList;

public class Rubric {

    private Student student;
    private ArrayList<Criteria> criteria = new ArrayList<>();

    public Rubric() {
    }

    public Rubric(Student student, ArrayList<Criteria> criteria) {
        this.student = student;
        this.criteria = criteria;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criteria> criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "student=" + student +
                ", criteria=" + criteria +
                '}';
    }
}
