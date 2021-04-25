package main;

import java.util.ArrayList;

// rubric class that has a student's name and list of criteria
public class Rubric {

    private String studentName;
    private ArrayList<Criteria> criteria = new ArrayList<>();

    public Rubric() {
    }

    public Rubric(String studentName, ArrayList<Criteria> criteria) {
        this.studentName = studentName;
        this.criteria = criteria;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criteria> criteria) {
        this.criteria = criteria;
    }

    public void addCriteria(Criteria criteria) {
        this.criteria.add(criteria);
    }

    @Override
    public String toString() {
        return
                "Student=" + studentName +
                ", Criteria=" + criteria;
    }
}
