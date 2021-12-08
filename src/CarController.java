import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        int i = 0;
        for (var vehicle: cc.cars) {
            vehicle.setLocation(new Point(0, i));
            i += 100;
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();

                if (Objects.equals(car.getModelName(), "Saab95")) {
                    //out.println(car.getPosition());
                }

                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());

                frame.drawPanel.moveit(car, x, y);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                isOutOfBounds(car);
            }
        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brakeAmount);
        }
    }

    void isOutOfBounds (Vehicle vehicle) {
        if (vehicle.getCurrentSpeed() > 0.1) {
            double posX = vehicle.getPosition().getX();
            double posY = vehicle.getPosition().getY();

            if (posX > 700) {
                invertDirection(vehicle);
                vehicle.setLocation(new Point(700, (int) posY));
                out.println("OutOfBOunds!!!!");
            } else if (vehicle.getPosition().getX() < 0) {
                invertDirection(vehicle);
                vehicle.setLocation(new Point(0, (int) posY));
                out.println("OutOfBOunds!!!!");
            } else if (vehicle.getPosition().getY() < 0) {
                invertDirection(vehicle);
                vehicle.setLocation(new Point((int) posX, 0));
                out.println("OutOfBOunds!!!!");

            } else if (vehicle.getPosition().getY() > 700) {
                invertDirection(vehicle);
                vehicle.setLocation(new Point((int) posX, 700));
                out.println("OutOfBOunds!!!!");

            }
        }

    }

    void invertDirection(Vehicle vehicle) {
        vehicle.turnRight();
        vehicle.turnRight();
        vehicle.stopEngine();
        vehicle.startEngine();
    }
}
