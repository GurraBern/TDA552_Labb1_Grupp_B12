import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
        setTurboOff();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        //return enginePower * 0.01 * turbo;    Changed!
        return getEnginePower() * 0.01 * turbo;
    }
}
