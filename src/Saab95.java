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
        if (turboOn)
            setTurboOff();
        else {
            setTurboOn();
        }
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
