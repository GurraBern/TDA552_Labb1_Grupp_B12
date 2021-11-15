import java.awt.*;

import static java.lang.System.out;

public class Volvo240 extends Car{
    private static double trimFactor = 1.25;

    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 100);
    }

    @Override
    protected double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
