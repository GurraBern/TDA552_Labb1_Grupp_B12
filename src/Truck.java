import java.awt.*;

public class Truck extends Vehicle{
    public Truck(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }

    /**
     * Calculates how fast the Car should accelerate or decelerate
     */
    @Override
    protected double speedFactor() {
        return this.getEnginePower() * 0.005;
    }
}
