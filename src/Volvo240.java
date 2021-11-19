import java.awt.*;

public class Volvo240 extends Car {

    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 100);
    }

    public double speedFactor(){
        double trimFactor = 1.25;
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
