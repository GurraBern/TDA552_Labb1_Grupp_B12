import java.awt.*;
import java.sql.Time;

public class Car extends Movable {
    //added final to variables
    public final String modelName; // The car model name
    private Color color; // Color of the car
    private final int nrDoors; // Number of doors on the car
    private double currentSpeed; // The current speed of the car
    private final double enginePower; // Engine power of the car
    private final static double trimFactor = 1.25;
    public float currentPosition;

    public Car(String modelName, Color color, Integer nrDoors, double enginePower) {
        this.modelName = modelName;
        setColor(color);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
        //this.currentPosition = new Vector2(0, 0);
    }
    //Set
    void move(String direction) {
        if (direction == "w") {
            gas(1);
        }

        //this.currentPosition.x += currentSpeed;
        //this.currentPosition.y += currentSpeed;
        this.currentPosition += currentSpeed;
        //if input = s
        //brake(1);
    }
    void turnLeft() {

    }
    void turnRight() {

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
    /*public Vector2 getCurrentPosition(){
        return this.currentPosition;
    }*/

    private void setColor(Color clr){
        this.color = clr;
    }

    public void startEngine(){
        this.currentSpeed = 0.1;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }

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

    public class Vector2 {
        public float x;
        public float y;

        public  Vector2(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
