package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final Scanner scan = new Scanner(System.in);
    private final ArrayList<Topic> topics = new ArrayList<>();

    public Controller() {
        int i = 1;

        displayMenu();
        do {
            i = scan.nextInt();

            switch (i) {
                case 1 -> createTopic();
                case 2 -> createRubric();
                case 3 -> addCriteriaToRubric();
                case 4 -> updateStudentCriteria();
                case 5 -> listAllTopics();
                case 6 -> getRubricsByName();
                case 7 -> studentRubricSummary();
                case 8 -> getSummaryOfCriteria();
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
        System.out.println("4. Update Student Criteria Score");
        System.out.println("5. Get List of Topics");
        System.out.println("6. Get Rubrics by Name");
        System.out.println("7. Get Summary of Student Rubric");
        System.out.println("8. Get Summary of Criteria");
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

    public void addCriteriaToRubric() {
        System.out.println("Please enter topic name");
        String topicName = scan.next();

        boolean found = false;

        for(Topic topic: topics) {
            if(topic.getTopicName().equalsIgnoreCase(topicName)) {
                found = true;

                System.out.println("Please enter student name");
                String studentName = scan.next();

                for(Rubric rubric: topic.getRubrics()) {
                    if(rubric.getStudentName().equalsIgnoreCase(studentName)) {
                        System.out.println("Please name for new criteria");
                        String critName = scan.next();

                        System.out.println("Please score for new criteria");
                        int critScore = scan.nextInt();

                        Criteria criteria = new Criteria(critName, critScore);
                        rubric.addCriteria(criteria);

                        break;
                    }
                }
            }
            break;
        }
        if(!found) {
            System.out.println("No topic was found \n");
        }
    }

    public void listAllTopics() {
        for(Topic t: topics) {
            System.out.println(t.getTopicName());
        }
    }

    public void getRubricsByName() {
        System.out.println("Please enter topic name");
        String topicName = scan.next();

        boolean found = false;

        for(Topic topic: topics) {
            if (topic.getTopicName().equalsIgnoreCase(topicName)) {
                found = true;

                for (Rubric r : topic.getRubrics()) {
                    System.out.println(r.toString());
                }
            }
        }

        if(!found) {
            System.out.println("No topic was found");
        }
    }

    public void updateStudentCriteria() {
        System.out.println("Please enter topic name");
        String topicName = scan.next();

        boolean found = false;
        boolean foundCriteria = false;

        for (Topic topic : topics) {
            if (topic.getTopicName().equalsIgnoreCase(topicName)) {
                found = true;

                System.out.println("Please enter student name");
                String studentName = scan.next();

                for (Rubric rubric : topic.getRubrics()) {
                    if (rubric.getStudentName().equalsIgnoreCase(studentName)) {
                        System.out.println("Please name of criteria");
                        String critName = scan.next();

                        for(Criteria c: rubric.getCriteria()) {
                            if(c.getCriteriaName().equalsIgnoreCase(critName)) {

                                System.out.println("Please update score for criteria");
                                int critScore = scan.nextInt();

                                int index = rubric.getCriteria().indexOf(c);
                                rubric.getCriteria().get(index).setScore(critScore);

                                foundCriteria = true;

                                break;
                            }
                        }
                        break;
                    }
                }
            }
            break;
        }

        if(!found) {
            System.out.println("No topic was found \n");
        }
        if (foundCriteria) {
            System.out.println("Criteria updated \n");
        }
    }

    public void studentRubricSummary() {
        System.out.println("Please enter topic name");
        String topicName = scan.next();

        boolean found = false;

        for (Topic topic : topics) {
            if (topic.getTopicName().equalsIgnoreCase(topicName)) {
                found = true;

                System.out.println("Please enter student name");
                String studentName = scan.next();

                for (Rubric rubric : topic.getRubrics()) {
                    if (rubric.getStudentName().equalsIgnoreCase(studentName)) {

                        ArrayList<Criteria> criteria = rubric.getCriteria();

                        int average = getAverage(criteria);
                        double stdDev = getStandardDev(criteria);
                        Criteria minimumCriteria = getMinimum(criteria);
                        Criteria maxCriteria = getMax(criteria);

                        System.out.println("Student Summary: " + studentName);
                        System.out.println("Average: " + average);
                        System.out.println("Standard Deviation: " + stdDev);
                        System.out.println("Minimum Criteria: " + minimumCriteria.getCriteriaName()
                                                + ", " + minimumCriteria.getScore());
                        System.out.println("Maximum Criteria: " + maxCriteria.getCriteriaName()
                                + ", " + maxCriteria.getScore());

                        break;
                    }
                }
            }
            break;
        }

        if(!found) {
            System.out.println("No topic was found \n");
        }
    }

    public int getAverage(ArrayList<Criteria> criteria) {

        double sum = 0;

        for(Criteria c : criteria) {
            sum += c.getScore();
        }

        double average = sum / (double) criteria.size();

        return (int) Math.ceil(average);
    }

    public double getStandardDev(ArrayList<Criteria> criteria) {

        double mean;
        double sum = 0;
        double n = criteria.size();

        for(Criteria c : criteria) {
            sum += c.getScore();
        }

        mean = sum / (double) criteria.size();

        sum = 0;

        for(Criteria c: criteria) {
            sum+=Math.pow((c.getScore()-mean),2);
        }

        mean=sum/(n-1);

        return Math.sqrt(mean);
    }

    public Criteria getMinimum(ArrayList<Criteria> criterion) {
        int minimum = criterion.get(0).getScore();
        Criteria criteria = criterion.get(0);

        for(Criteria c: criterion) {
            if(c.getScore() < minimum) {
                minimum = c.getScore();

                criteria = c;
            }
        }

        return criteria;
    }

    public Criteria getMax(ArrayList<Criteria> criterion) {
        int max = criterion.get(0).getScore();
        Criteria criteria = criterion.get(0);

        for(Criteria c: criterion) {
            if(c.getScore() > max) {
                max = c.getScore();

                criteria = c;
            }
        }

        return criteria;
    }

    public void getSummaryOfCriteria() {
        System.out.println("Please enter topic name");
        String topicName = scan.next();

        ArrayList<Criteria> criteriaList = new ArrayList<>();

        String criteriaName = null;

        boolean found = false;

        for (Topic topic : topics) {
            if (topic.getTopicName().equalsIgnoreCase(topicName)) {
                found = true;

                System.out.println("Please enter criteria name");
                criteriaName = scan.next();

                for (Rubric rubric : topic.getRubrics()) {
                   for(Criteria c: rubric.getCriteria()) {
                       if(c.getCriteriaName().equalsIgnoreCase(criteriaName)) {
                           criteriaList.add(c);
                       }
                   }
                }
                break;
            }
        }

        int average = getAverage(criteriaList);
        double stdDev = getStandardDev(criteriaList);
        Criteria minimumCriteria = getMinimum(criteriaList);
        Criteria maxCriteria = getMax(criteriaList);

        System.out.println("Criteria Summary: " + criteriaName);
        System.out.println("Average: " + average);
        System.out.println("Standard Deviation: " + stdDev);
        System.out.println("Minimum Score: " + minimumCriteria.getCriteriaName()
                + ", " + minimumCriteria.getScore());
        System.out.println("Maximum Score: " + maxCriteria.getCriteriaName()
                + ", " + maxCriteria.getScore());

        if(!found) {
            System.out.println("No topic was found \n");
        }
    }
}
