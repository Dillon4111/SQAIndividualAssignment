import main.Controller;
import org.junit.Test;

public class TestController {

    @Test
    public void testAdd() {
        Controller controller = new Controller();

        assert
                controller.add(1, 2) == 3;
    }
}
