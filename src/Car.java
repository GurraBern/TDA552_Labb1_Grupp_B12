import java.awt.*;
import java.util.Objects;

public abstract class Car implements Movable {
    private final String modelName; // The car model name
    private Color color; // Color of the car
    private final int nrDoors; // Number of doors on the car
    protected double currentSpeed; // The current speed of the car
    private final double enginePower; // Engine power of the car
    private Point currentPosition = new Point(0,0);
    private int directionNumber = 0;
    private boolean engineOn;

    public Car(String modelName, Color color, Integer nrDoors, double enginePower) {
        this.modelName = modelName;
        setColor(color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    public void move(String input) {
        userInput(input);
        updatePosition(this.currentPosition);
    }

    protected void basicMovementInput(String input) {
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

    protected void userInput(String input) {
        startButton(input);
        if (engineOn)
            basicMovementInput(input);
    }

    public void turnLeft() {
        if (this.directionNumber != 0) {
            this.directionNumber -= 1;
        } else {
            this.directionNumber = 3;
        }
    }

    public void turnRight() {
        if (this.directionNumber != 3) {
            this.directionNumber += 1;
        } else {
            this.directionNumber = 0;
        }
    }

    private Point updatePosition(Point currentPosition)  {
        if (directionNumber == 0) {
            currentPosition.y += currentSpeed;
        } else if (directionNumber == 1) {
            currentPosition.x += currentSpeed;
        } else if (directionNumber == 2) {
            currentPosition.y -= currentSpeed;
        } else if (directionNumber == 3) {
            currentPosition.x -= currentSpeed;
        }
        return currentPosition;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getNrDoors(){
        return this.nrDoors;
    }

    public double getEnginePower(){
        return this.enginePower;
    }

    public double getCurrentSpeed(){
        return this.currentSpeed;
    }

    public Point getCurrentPosition() {
        return this.currentPosition;
    }

    public Color getColor(){
        return this.color;
    }

    public boolean getEngineState(){
        return this.engineOn;
    }

    public int getCurrentDirection() {
        return this.directionNumber;
    }

    private void setColor(Color clr){
        this.color = clr;
    }

    private void startEngine() {
        this.currentSpeed = 0.1;
        this.engineOn = true;
    }

    private void stopEngine(){
        this.currentSpeed = 0;
        this.engineOn = false;
    }

    public void startButton(String input){
        if (Objects.equals(input, "e")) {
            if (!engineOn)
                startEngine();
            else {
                stopEngine();
            }
        }
    }

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }
}
