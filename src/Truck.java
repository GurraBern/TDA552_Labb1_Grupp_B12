import java.awt.*;
import java.util.Objects;

public class Truck extends Vehicle{
    public Truck(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }

    @Override
    protected double speedFactor() {
        return 0;
    }
}
