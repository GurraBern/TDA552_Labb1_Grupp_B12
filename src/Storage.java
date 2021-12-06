import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Storage<T extends Car> {
    private int storageLimit;
    private ArrayList<T> storedCars = new ArrayList<>();
    private Point2D position;

    public Storage(int storageLimit, Point2D position) {
        this.storageLimit = storageLimit;
        this.position = position;
    }

    /**
     * Loads car into the ArrayList storedCars and removes from the world
     * @param car The car to should be added to the Storage
     * @param worldCars List of all the cars that exist in the world
     * @throws IllegalArgumentException If ramp is up
     */
    public void loadCar(T car, ArrayList worldCars){
        if (storedCars.size() < storageLimit) {
            var dist = calculateDistance(position, car.getPosition());
            if (dist <= 3) {
                car.pullHandbrake();
                storedCars.add(car);
                worldCars.remove(car);
            } else {
                throw new IllegalArgumentException("Car is to far away!");
            }
        } else {
            throw new IllegalArgumentException("There are no empty space for another car");
        }
    }

    /**
     * Unloads last car into the world
     * @param worldCars List of all the cars that exist in the world
     */
    public void unloadCar(ArrayList worldCars) {
        if (storedCars.size() > 0) {
            storedCars.get(storedCars.size()-1).releaseHandbrake();
            worldCars.add(storedCars.get(storedCars.size()-1));
            storedCars.remove(storedCars.size()-1);
        } else {
            throw new IllegalArgumentException("There are no stored cars to unload");
        }
    }

    /**
     * Sets location of the storage
     * @param position New position of the storage
     */
    public void setLocation(Point2D position) {
        this.position = position;
    }

    /**
     * Calculate the distance between two points
     * @param p1 Position of object 1
     * @param p2 Position of object 2
     */
    private double calculateDistance(Point2D p1, Point2D p2) {
        return Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2) + Math.pow((p1.getY()-p2.getY()), 2));
    }

    /**
     * Returns the storage limit
     */
    public int getStorageLimit() {
        return storageLimit;
    }

    /**
     * Returns a ArrayList of all the cars
     */
    public ArrayList<T> getCars () {
        return storedCars;
    }
}
