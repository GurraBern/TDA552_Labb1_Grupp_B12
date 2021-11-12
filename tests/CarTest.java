import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CarTest {
    @Test
    public void createCar() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);

        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(4, volvo240.getNrDoors());
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(100, (int) volvo240.getEnginePower());

    }

}