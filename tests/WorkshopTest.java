import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;

public class WorkshopTest {
    private ArrayList<Car> worldCars;

    @Test
    public void CreateWorkshop() {
        Workshop<Volvo240> workshop = new Workshop(1, new Point(0,0));

        assertEquals(1, workshop.getStorageLimit());
    }
}
