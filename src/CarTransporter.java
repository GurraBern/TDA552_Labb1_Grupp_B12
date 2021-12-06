import java.awt.*;
import java.util.ArrayList;

public class CarTransporter<T extends Car> extends TruckWithPlatform {
    private Storage<T> storage;


    /**
     *
     * @param storageLimit The capacity of how many cars
     */
    public CarTransporter(int storageLimit) {
        super("CarTransporter", Color.BLUE, 2, 900, 70);
        this.storage = new Storage<T>(storageLimit, getPosition());
    }

    /**
     * Moves Transport and all the contents of it's Storage
     */
    @Override
    public void move() {
        if(getAngle() == 0) {
            super.move();
            storage.setLocation(getPosition());
            for (Car car: storage.getCars()) {
                car.setLocation(getPosition());
            }
        }
    }

    /**
     * Loads car into the Storage of the CarTransporter and removes from the world
     * @param car The car to should be added to the CarTransporter
     * @param worldCars List of all the cars that exist in the world
     * @throws IllegalArgumentException If ramp is up
     */
    public void loadCar(T car, ArrayList<T> worldCars){
        if (getAngle() == getMaxAngle()) {
            storage.loadCar(car, worldCars);
        } else {
            throw new IllegalArgumentException("Transporter ramp must be down to load cars!");
        }
    }

    /**
     * Unloads last car into the world
     * @param worldCars List of all the cars that exist in the world
     */
    public void unloadCar(ArrayList<Volvo240> worldCars) {
        storage.unloadCar(worldCars);
    }

    /**
     * Returns a list with all cars from Storage
     */
    public ArrayList<T> getCars () {
        return storage.getCars();
    }

    /**
     * Raises the platform to be able to drive
     */
    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(0);
        }
    }

    /**
     * Returns the amount of cars that can be stored in this Storage
     */
    public int getStorageLimit() {
        return storage.getStorageLimit();
    }

    /**
     * Lowers platform to get ready to Load Cars
     */
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(70);
        }
    }
}
