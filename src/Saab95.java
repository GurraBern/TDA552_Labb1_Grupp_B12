import java.awt.*;
import java.util.Objects;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95(String modelName, Color color, Integer nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
        setTurboOff();
    }

    @Override
    protected void userInput(String input) {
        startButton(input);
        if (getEngineState()) {
            basicUserInput(input);

            if (Objects.equals(input, "t")){
                turboButton();
            }
        }
    }

    private void turboButton(){
        if (!turboOn)
            setTurboOn();
        else {
            setTurboOff();
        }
    }

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
