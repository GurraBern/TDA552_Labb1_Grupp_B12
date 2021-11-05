import java.awt.*;
import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) {
        Car volvo240 = new Car("Volvo240", Color.BLACK, 4, 100);
        Saab95 saab95 = new Saab95("Saab95", Color.RED, 2, 125);

        out.println(volvo240.getNrDoors());
    }
}
