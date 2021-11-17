import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class VolvoTest {
    Volvo240 volvo240;

    @Test
    public void CarCreate() {
        volvo240 = new Volvo240();
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(4, volvo240.getNrDoors());
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(100, (int) volvo240.getEnginePower());
    }
}