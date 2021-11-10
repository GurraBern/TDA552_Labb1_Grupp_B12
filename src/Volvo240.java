import java.awt.*;

import static java.lang.System.out;

public class Volvo240 extends Car{
    private static double trimFactor = 1.25;

    public Volvo240(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }

    @Override
    protected double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
