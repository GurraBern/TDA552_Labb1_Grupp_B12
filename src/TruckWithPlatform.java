import java.awt.*;
import java.util.Objects;

public abstract class TruckWithPlatform extends Truck {
    private int maxAngle;
    private int angle;

    public TruckWithPlatform(String modelName, Color color, Integer nrDoors, double enginePower, int maxAngle) {
        super(modelName, color, nrDoors, enginePower);
        this.maxAngle = maxAngle;
    }

    @Override
    public void basicMovementInput(String input) {
        if (angle == maxAngle) {
            if (Objects.equals(input, "w")) {
                gas(1);
            } else if (Objects.equals(input, "s")) {
                brake(1);
            } else if (Objects.equals(input, "d")) {
                turnRight();
            } else if (Objects.equals(input, "a")) {
                turnLeft();
            }
        }
    }
    public int getAngle() {
        return angle;
    }

    public int getMaxAngle() {
        return maxAngle;
    }

    public int raisePlatform(int currentAngle, int platformStep) {
        currentAngle += platformStep;
        if (angle > maxAngle) {
            angle = maxAngle;
        }
        return currentAngle;
    }

    public int lowerPlatform(int currentAngle, int platformStep) {
        if (getCurrentSpeed() == 0) {
            currentAngle -= platformStep;
            if (angle < 0) {
                angle = 0;
            }
            return currentAngle;
        }
        //TODO Error
        return 0;
    }
}
