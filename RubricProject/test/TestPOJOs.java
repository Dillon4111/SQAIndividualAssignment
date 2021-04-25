import main.Criteria;
import main.Rubric;
import main.Student;
import main.Topic;
import org.junit.Test;

import java.util.ArrayList;

// simple test suite to make sure all POJOs are working correctly
public class TestPOJOs {

    @Test
    public void testStudent() {
        Student student = new Student();
        student.setStudentName("Dillon Rochford");

        assert
                student.getStudentName().equals("Dillon Rochford");
    }

    @Test
    public void testCriteria() {
        Criteria criteria = new Criteria("Grammar", 5);

        assert
                criteria.getScore() == 5;
    }

    @Test
    public void testRubric() {
        Student student = new Student();
        student.setStudentName("Dillon Rochford");

        Criteria criteria = new Criteria("Grammar", 5);
        Criteria criteria2 = new Criteria("Writing", 3);

        ArrayList<Criteria> criterion = new ArrayList<>();
        criterion.add(criteria);
        criterion.add(criteria2);

        Rubric rubric = new Rubric(student.getStudentName(), criterion);

        assert
                rubric.getCriteria().get(0) == criteria;

    }

    @Test
    public void testTopic() {
        Student student = new Student();
        student.setStudentName("Dillon Rochford");
        Student student2 = new Student();
        student2.setStudentName("John Pope");

        Criteria criteria = new Criteria("Grammar", 5);
        Criteria criteria2 = new Criteria("Writing", 3);
        Criteria criteria3 = new Criteria("Listening", 1);

        ArrayList<Criteria> criterion = new ArrayList<>();
        criterion.add(criteria);
        criterion.add(criteria2);

        ArrayList<Criteria> criterion2 = new ArrayList<>();
        criterion2.add(criteria3);

        Rubric rubric = new Rubric(student.getStudentName(), criterion);
        Rubric rubric2 = new Rubric(student2.getStudentName(), criterion2);

        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(rubric);
        rubrics.add(rubric2);

        Topic topic = new Topic("English", rubrics);

        assert
                topic.getRubrics().get(0).getStudentName().equals("Dillon Rochford");
        assert
                topic.getRubrics().get(1).getStudentName().equals("John Pope");

    }
}
