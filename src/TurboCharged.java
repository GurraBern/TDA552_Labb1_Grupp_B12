import java.awt.*;

public abstract class TurboCharged extends Car{
    private boolean turboOn;

    public TurboCharged(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
