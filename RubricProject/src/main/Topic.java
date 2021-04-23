package main;

import java.util.ArrayList;

public class Topic {

    private String topicName;
    private ArrayList<Rubric> rubrics = new ArrayList<>();

    public Topic() {

    }

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    public Topic(String topicName, ArrayList<Rubric> rubrics) {
        this.topicName = topicName;
        this.rubrics = rubrics;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public ArrayList<Rubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(ArrayList<Rubric> rubrics) {
        this.rubrics = rubrics;
    }

    public void addRubric(Rubric rubric) {
        rubrics.add(rubric);
    }

    @Override
    public String toString() {
        return
                "TopicName='" + topicName + '\'' +
                ", Rubrics=" + rubrics;
    }
}
