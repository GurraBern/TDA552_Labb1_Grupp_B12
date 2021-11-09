import java.awt.*;
import java.util.Objects;
import java.util.Vector;

import static java.lang.System.out;

public class Car implements Movable {
    //added final to variables
    public final String modelName; // The car model name
    private Color color; // Color of the car
    private final int nrDoors; // Number of doors on the car
    private double currentSpeed; // The current speed of the car
    private final double enginePower; // Engine power of the car
    private final static double trimFactor = 1.25;
    public Point currentPosition = new Point(0,0);

    public Car(String modelName, Color color, Integer nrDoors, double enginePower) {
        this.modelName = modelName;
        setColor(color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
    }

    public void move(String input) {
        if (currentSpeed > 0) {
            if (Objects.equals(input, "w")) {
                gas(1);
            } else if (Objects.equals(input, "s")) {
                brake(1);
            } else if (Objects.equals(input, "d")) {
                turnRight();
            } else if (Objects.equals(input, "a")) {
                turnLeft();
            }
        } else if (Objects.equals(input, "e")) {
            this.startEngine();
        }

        updatePosition(this.currentPosition);
        gas(0);
    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

    private Point updatePosition(Point currentPosition)  {
        currentPosition.x += currentSpeed;
        currentPosition.y += currentSpeed;
        return currentPosition;
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

    // TODO ta bort trimfactor och lägg på volvo
    private double speedFactor(){
        return this.enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
        this.currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        this.currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
