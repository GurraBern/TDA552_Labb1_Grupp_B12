import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class CarTest {
    Volvo240 volvo240;
    @Before
    public void init() {
        volvo240 = new Volvo240();
    }

    @Test
    public void CarCreate() {
        volvo240 = new Volvo240();
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(4, volvo240.getNrDoors());
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(100, (int) volvo240.getEnginePower());
    }

    @Test
    public void CarMoveForward() {
        volvo240.move("w");
        assertEquals(0, (int) (volvo240.getCurrentPosition().getX() + volvo240.getCurrentPosition().getY()));
        volvo240.startButton("e");
        volvo240.move("w");
        assertEquals(1, (int) (volvo240.getCurrentPosition().getX() + volvo240.getCurrentPosition().getY()));
    }

    @Test
    public void CarUserInput() {
        volvo240.move("e");
        volvo240.move("w");
        assertEquals(1, volvo240.getCurrentPosition().getX() + volvo240.getCurrentPosition().getY(), 0.1);

        volvo240.move("s");
        assertEquals(0, volvo240.getCurrentSpeed(), 0.2);

        volvo240.move("a");
        assertEquals(3, volvo240.getCurrentDirection(), 0.1);

        volvo240.move("d");
        assertEquals(0, volvo240.getCurrentDirection(), 0.1);
    }

    @Test
    public void turnLeft() {
        volvo240.turnLeft();
        volvo240.turnLeft();
        volvo240.turnLeft();
        volvo240.turnLeft();
        assertEquals(0, volvo240.getCurrentDirection());
    }

    @Test
    public void CarTurnRight() {
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.turnRight();
        assertEquals(0, volvo240.getCurrentDirection());
    }

    @Test
    public void CarDriveRight() {
        volvo240.startButton("e");
        volvo240.turnRight();
        volvo240.move("w");
        assertEquals(1, volvo240.getCurrentPosition().getX(), 0.1);
    }

    @Test
    public void CarDriveDown() {
        volvo240.startButton("e");
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.move("w");
        assertEquals(-1, volvo240.getCurrentPosition().getY(), 0.1);
    }

    @Test
    public void CarStartEngine() {
        volvo240.startButton("e");
        assertTrue(volvo240.getEngineState());
    }

    @Test
    public void CarStopEngine() {
        volvo240.startButton("e");
        volvo240.startButton("e");
        assertFalse(volvo240.getEngineState());
    }

    @Test
    public void CarGetCurrentPosition() {
        volvo240.startButton("e");
        volvo240.move("w");

        assertEquals(1, volvo240.getCurrentPosition().y);
    }

    @Test
    public void CarGas() {
        volvo240.startButton("e");
        volvo240.gas(1);
        assertEquals(1, volvo240.getCurrentSpeed(), 0.5);
    }

    @Test
    public void CarBrake() throws Exception {
        volvo240.startButton("e");
        volvo240.gas(1);
        volvo240.brake(1);

        assertEquals(0, volvo240.getCurrentSpeed(), 0.2);
    }
}