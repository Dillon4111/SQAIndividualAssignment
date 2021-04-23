package main;

public class Controller {

    public Controller() {}

    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentName("Dillon");

        Criteria criteria = new Criteria("Coding", 4);

        System.out.println("Student name: " + student.getStudentName() + "\n" +
                            "Criteria: " + criteria.toString());
    }

    public int add(int a, int b) {
        return a + b;
    }
}
