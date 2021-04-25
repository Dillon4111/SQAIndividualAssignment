package main;

// criteria class that has a name and score
public class Criteria {

    private String criteriaName;
    private int score;

    public Criteria() {
    }

    public Criteria(String criteriaName, int score) {
        this.criteriaName = criteriaName;
        this.score = score;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return
                "CriteriaName='" + criteriaName + '\'' +
                ", Score=" + score;
    }
}
