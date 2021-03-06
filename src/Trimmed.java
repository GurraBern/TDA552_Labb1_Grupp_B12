import java.awt.*;

public abstract class Trimmed extends Car{
    public Trimmed(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }

    public double speedFactor(){
        double trimFactor = 1.25;
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}
