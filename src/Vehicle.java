import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

public abstract class Vehicle implements IMovable {
    private final String modelName; // The car model name
    private Color color; // Color of the car
    private final int nrDoors; // Number of doors on the car
    private double currentSpeed; // The current speed of the car
    private final double enginePower; // Engine power of the car
    private Point2D currentPosition = new Point(0,0);
    private int directionNumber = 0;
    private boolean engineOn;
    private boolean handBrakeUp;

    public Vehicle(String modelName, Color color, Integer nrDoors, double enginePower) {
        this.modelName = modelName;
        setColor(color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        handBrakeUp = false;
        stopEngine();
    }

    public void move() {
        double x = currentPosition.getX();
        double y = currentPosition.getY();

        double speed = getCurrentSpeed();
        if (Objects.equals(modelName, "Saab95")) {
            out.println("current speed " + currentSpeed);

        }

        switch (directionNumber) {
            case 0 -> x += speed;
            case 1 -> y += speed;
            case 2 -> x -= speed;
            case 3 -> y -= speed;
        }
        this.currentPosition.setLocation(x, y);
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

    public void setLocation(Point2D position){
        this.currentPosition = position;
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

    public Point2D getPosition() {
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

    public void setColor(Color clr){
        this.color = clr;
    }

    public void pullHandbrake() {
        handBrakeUp = true;
    }

    public void releaseHandbrake() {
        handBrakeUp = false;
    }



    public void startEngine() {
        this.currentSpeed = 0.1;
        this.engineOn = true;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
        this.engineOn = false;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected abstract double speedFactor();

    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && engineOn && !handBrakeUp)
            incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }
}
