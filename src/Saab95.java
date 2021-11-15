import java.awt.*;
import java.util.Objects;

public class Saab95 extends Car{
    private boolean turboOn;

    public Saab95() {
        super("Saab95", Color.RED, 2, 125);
        setTurboOff();
    }

    @Override
    protected void userInput(String input) {
        startButton(input);
        if (getEngineState()) {
            basicMovementInput(input);

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

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
}
