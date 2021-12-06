import java.awt.*;
import java.util.Objects;

public abstract class TruckWithPlatform extends Truck {
    private int maxAngle;
    private int angle = 0;

    public TruckWithPlatform(String modelName, Color color, Integer nrDoors, double enginePower, int maxAngle) {
        super(modelName, color, nrDoors, enginePower);
        this.maxAngle = maxAngle;
    }

    /**
     * Returns the angle of the platform
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Sets angle to value
     */
    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * Returns the greatest angle the platform can have
     */
    public int getMaxAngle() {
        return maxAngle;
    }

    /**
     * Raises the platform based on the platformStep
     * @param platformStep Decides how much the platform should be raised each call
     */
    protected void raisePlatform(int platformStep) {
        angle -= platformStep;
        if (angle < 0) {
            angle = 0;
        }
    }

    /**
     * Lowers the platform based on the platformStep
     * @param platformStep Decides how much the platform should be lowered each call
     */
    protected void lowerPlatform(int platformStep) {
        if (getCurrentSpeed() == 0) {
            angle += platformStep;
            if (angle >= maxAngle) {
                angle = maxAngle;
            }
        }
    }
}
