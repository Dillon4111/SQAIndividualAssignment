package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private Scanner scan = new Scanner(System.in);
    private ArrayList<Topic> topics = new ArrayList<>();

    public Controller() {
        int i = 1;

        displayMenu();
        do {
            i = scan.nextInt();

            switch (i) {
                case 1:
                    createTopic();
                    break;
                case 2:
                    createRubric();
                    break;
            }

            displayMenu();

        } while (i > 0 && i < 10);
    }

    public static void main(String[] args) {
        new Controller();
    }

    public void displayMenu() {
        System.out.println("1. Create Topic");
        System.out.println("2. Create Rubric for Topic");
        System.out.println("3. Add Criteria to Rubric");
        System.out.println("4. Get List of Topics");
        System.out.println("5. Get Rubrics by Name");
    }

    public void createTopic() {
        System.out.println("Please enter topic name");
        scan.nextLine();
        String name = scan.nextLine();

        boolean found = false;
        for(Topic t: topics) {
            if (t.getTopicName().equalsIgnoreCase(name)) {
                found = true;
                break;
            }
        }

        if(found) {
            System.out.println("Topic already created \n");
        }
        else {
            Topic topic = new Topic(name);
            topics.add(topic);
            System.out.println("Topic - " + name + " created \n");
        }
    }

    public void createRubric() {
        System.out.println("Please enter topic name");
        String name = scan.next();

        ArrayList<Criteria> criterion = null;
        boolean found = false;

        for(Topic topic: topics) {
            if(topic.getTopicName().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Please enter student name");
                String studentName = scan.next();

                System.out.println("Please enter number of criteria");
                int i = scan.nextInt();

                for(int ii = 0; ii < i; ii++) {
                    System.out.println("Please enter name of criteria");
                    String criteriaName = scan.next();

                    System.out.println("Please enter score of criteria");
                    int criteriaScore = scan.nextInt();
                    
                    Criteria criteria = new Criteria(criteriaName, criteriaScore);
                    criterion = new ArrayList<>();
                    criterion.add(criteria);
                }
                
                Rubric rubric = new Rubric(studentName, criterion);
                topic.addRubric(rubric);
                
                break;
            }
        }
        if(!found) {
            System.out.println("No topic was found");
        }
    }

    public int add(int a, int b) {
        return a + b;
    }
}
