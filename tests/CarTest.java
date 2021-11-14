import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void CarCreate() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(4, volvo240.getNrDoors());
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(100, (int) volvo240.getEnginePower());
    }

    @Test
    public void CarMove() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.move("w");
        assertEquals(0, (int) (volvo240.getCurrentPosition().getX() + volvo240.getCurrentPosition().getY()));
        volvo240.startButton("e");
        volvo240.move("w");
        assertEquals(1, (int) (volvo240.getCurrentPosition().getX() + volvo240.getCurrentPosition().getY()));
    }

    @Test
    public void CarTurnLeft() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.move("a");
        volvo240.move("a");
        volvo240.move("a");
        volvo240.move("a");

        assertEquals(0, volvo240.getCurrentDirection());
    }
    @Test
    public void CarTurnRight() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.move("d");
        volvo240.move("d");
        volvo240.move("d");
        volvo240.move("d");

        assertEquals(0, volvo240.getCurrentDirection());
    }
    @Test
    public void CarStartEngine() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.startButton("e");
        assertTrue(volvo240.getEngineState());
    }

    @Test
    public void CarStopEngine() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.startButton("e");
        volvo240.startButton("e");
        assertFalse(volvo240.getEngineState());
    }

    @Test
    public void CarGetCurrentPosition() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.startButton("e");
        volvo240.move("w");

        assertEquals(1, volvo240.getCurrentPosition().y);
    }

    @Test
    public void CarGas() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.startButton("e");
        volvo240.gas(1);
        assertEquals(1, volvo240.getCurrentSpeed(), 0.5);
    }

    @Test
    public void CarBrake() {
        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        volvo240.startButton("e");
        volvo240.gas(1);
        volvo240.brake(1);

        assertEquals(0, volvo240.getCurrentSpeed(), 0.2);
    }
}