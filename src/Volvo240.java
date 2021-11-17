import java.awt.*;

public class Volvo240 extends Car{
    private static double trimFactor = 1.25;

    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 100);
    }

    private double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
