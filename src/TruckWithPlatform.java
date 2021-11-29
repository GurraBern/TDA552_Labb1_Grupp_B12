import java.awt.*;
import java.util.Objects;

public abstract class TruckWithPlatform extends Truck {
    private int maxAngle;
    private int angle = 0;

    public TruckWithPlatform(String modelName, Color color, Integer nrDoors, double enginePower, int maxAngle) {
        super(modelName, color, nrDoors, enginePower);
        this.maxAngle = maxAngle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getMaxAngle() {
        return maxAngle;
    }

    protected void raisePlatform(int platformStep) {
        angle -= platformStep;
        if (angle < 0) {
            angle = 0;
        }
    }

    protected void lowerPlatform(int platformStep) {
        if (getCurrentSpeed() == 0) {
            angle += platformStep;
            if (angle >= maxAngle) {
                angle = maxAngle;
            }
        }
    }
}
