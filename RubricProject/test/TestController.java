import main.Controller;
import main.Criteria;
import org.junit.Test;

import java.util.ArrayList;

public class TestController {

    @Test
    public void testAverageOfRubric() {
        ArrayList<Criteria> criteria = getCriteriaList();
        Controller controller = new Controller();

        assert
                controller.getAverageOfRubric(criteria) == 3;
    }

    @Test
    public void testStandardDevOfRubric() {
        ArrayList<Criteria> criteria = getCriteriaList();
        Controller controller = new Controller();

        assert
                controller.getStandardDevOfRubric(criteria) == 1.2909944487358056;
    }

    @Test
    public void testGetMinimumOfRubric() {
        ArrayList<Criteria> criteria = getCriteriaList();
        Controller controller = new Controller();

        assert
                controller.getMinimumOfRubric(criteria) == criteria.get(0);
    }

    @Test
    public void testGetMaxOfRubric() {
        ArrayList<Criteria> criteria = getCriteriaList();
        Controller controller = new Controller();

        assert
                controller.getMaxOfRubric(criteria) == criteria.get(3);
    }


    public ArrayList<Criteria> getCriteriaList() {
        Criteria c1 = new Criteria("A", 1);
        Criteria c2 = new Criteria("B", 2);
        Criteria c3 = new Criteria("C", 3);
        Criteria c4 = new Criteria("D", 4);

        ArrayList<Criteria> criteria = new ArrayList<>();
        criteria.add(c1);
        criteria.add(c2);
        criteria.add(c3);
        criteria.add(c4);

        return criteria;
    }
}
