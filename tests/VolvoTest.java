import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class VolvoTest {
    Volvo240 volvo240;

    @Test
    public void VolvoCreate() {
        volvo240 = new Volvo240();
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(Color.BLACK, volvo240.getColor());
        assertEquals(4, volvo240.getNrDoors());
        assertEquals("Volvo240", volvo240.getModelName());
        assertEquals(100, (int) volvo240.getEnginePower());
    }

    @Test
    public void VolvoGas() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.gas(1);
        assertEquals(1.25, volvo240.getCurrentSpeed(), 0.2);
    }

    @Test
    public void TurnRight() {
        volvo240 = new Volvo240();
        volvo240.gas(1);
        volvo240.turnRight();
        assertEquals(1, volvo240.getCurrentDirection());
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.turnRight();
        assertEquals(0, volvo240.getCurrentDirection());
    }
    @Test
    public void TurnLeft() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.gas(1);
        volvo240.turnLeft();
        assertEquals(3, volvo240.getCurrentDirection());
        volvo240.turnLeft();
        volvo240.turnLeft();
        volvo240.turnLeft();
        assertEquals(0, volvo240.getCurrentDirection());
    }

    @Test
    public void MoveForward() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(1, volvo240.getPosition().y, 0.2);
    }

    @Test
    public void MoveRight() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.turnRight();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(1, volvo240.getPosition().x, 0.2);
    }

    @Test
    public void MoveDown() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(-1, volvo240.getPosition().y, 0.2);
    }

    @Test
    public void MoveLeft() {
        volvo240 = new Volvo240();
        volvo240.startButton();
        volvo240.turnLeft();
        volvo240.gas(1);
        volvo240.move();
        assertEquals(-1, volvo240.getPosition().x, 0.2);
    }

    @Test
    public void GetNrDoors() {
        volvo240 = new Volvo240();
        assertEquals(4, volvo240.getNrDoors());
    }
}