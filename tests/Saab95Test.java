import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class Saab95Test {
    Saab95 saab95;

    @Before
    public void init() {
        saab95 = new Saab95();
    }

    @Test
    public void CreateSaab95() {
        saab95 = new Saab95();
        assertEquals("Saab95", saab95.getModelName());
        assertEquals(Color.RED, saab95.getColor());
        assertEquals(2, saab95.getNrDoors());
        assertEquals(125, (int) saab95.getEnginePower());
    }

    @Test
    public void Saab95Inputs() {
        saab95 = new Saab95();
        saab95.move("e");
        assertTrue(saab95.getEngineState());
        saab95.move("e");
        assertFalse(saab95.getEngineState());
    }

    @Test
    public void SaabTurboTest() {
        saab95.startButton("e");
        saab95.move("t");
        assertTrue(saab95.getTurboOn());
        saab95.move("t");
        assertFalse(saab95.getTurboOn());
    }

    @Test
    public void Saab95GasTest() {
        saab95.startButton("e");
        saab95.gas(1);
        assertEquals(1.35, saab95.getCurrentSpeed(), 0.2);
    }

    @Test
    public void Saab95Brake() {
        saab95.startButton("e");
        saab95.gas(1);
        saab95.brake(1);
        assertEquals(0, saab95.getCurrentSpeed(), 0.2);
    }
}