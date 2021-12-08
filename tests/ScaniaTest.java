import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ScaniaTest {
    @Test
    public void ScaniaCreate() {
        Scania scania = new Scania();
        assertEquals("Scania", scania.getModelName());
        assertEquals(Color.BLACK, scania.getColor());
        assertEquals(2, scania.getNrDoors());
        assertEquals(900, (int) scania.getEnginePower());
    }

    @Test
    public void ScaniaRaisePlatform() {
        Scania scania = new Scania();
        scania.raisePlatform(70);
        assertEquals(0, scania.getAngle());
    }

    @Test
    public void ScaniaLowerPlatform() {
        Scania scania = new Scania();
        scania.raisePlatform(70);
        scania.lowerPlatform(70);
        assertEquals(70, scania.getAngle());
    }

    @Test
    public void ScaniaLowerPlatformError() {
        Scania scania = new Scania();
        scania.lowerPlatform(100);
        assertEquals(70, scania.getAngle());
    }
}
