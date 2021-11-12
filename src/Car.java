import java.awt.*;
import java.util.Objects;

public abstract class Car implements Movable {
    private String modelName; // The car model name
    private Color color; // Color of the car
    private int nrDoors; // Number of doors on the car
    private double currentSpeed; // The current speed of the car
    private double enginePower; // Engine power of the car
    private Point currentPosition = new Point(0,0);
    private int directionNumber = 0;

    public Car(String modelName, Color color, Integer nrDoors, double enginePower) {
        this.modelName = modelName;
        setColor(color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    public void move(String input) {
        //gas(0);
        userInput(input);
        if (Objects.equals(input, "e")) {
            if (getCurrentSpeed() <= 0)
                startEngine();
            else {
                stopEngine();
            }
        }




        updatePosition(this.currentPosition);
    }

    public void userInput(String input) {
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

    public void turnLeft() {
        if (directionNumber != 0) {
            directionNumber -= 1;
        } else {
            directionNumber = 3;
        }
    }

    public void turnRight() {
        if (directionNumber != 3) {
            directionNumber += 1;
        } else {
            directionNumber = 0;
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

    private void setColor(Color clr){
        this.color = clr;
    }

    public void startEngine(){
        this.currentSpeed = 0.1;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        this.currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (getCurrentSpeed() > getEnginePower())
            this.currentSpeed = getEnginePower();
    }

    private void decrementSpeed(double amount){
        this.currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (this.currentSpeed < 0)
            this.currentSpeed = 0;
    }

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }
}
