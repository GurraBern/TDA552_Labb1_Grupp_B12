import java.awt.*;
import java.util.Objects;

public class Saab95 extends Car {
    private boolean turboOn;

    public Saab95() {
        super("Saab95", Color.RED, 2, 125);
        turboOn = false;
        //setTurboOff();
    }

    @Override
    protected void userInput(String input) {
        if (input.equals("e"))
            startButton();
        if (getEngineState()) {
            basicMovementInput(input);

            if (Objects.equals(input, "t")){
                turboButton();
            }
        }
    }

    private void turboButton(){
        if (turboOn)
            turboOn = false;
            //setTurboOff();
        else {
            turboOn = true;
            //setTurboOn();
        }
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    //private void setTurboOn(){
	    //turboOn = true;
    //}

    //private void setTurboOff(){
	    //turboOn = false;
    //}

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
