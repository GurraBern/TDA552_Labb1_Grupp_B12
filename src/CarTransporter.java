import java.awt.*;
import java.util.ArrayList;

public class CarTransporter<T extends Car> extends TruckWithPlatform {
    private Storage<T> storage;

    public CarTransporter(int storageLimit) {
        super("CarTransporter", Color.BLUE, 2, 900, 70);
        this.storage = new Storage<T>(storageLimit, getPosition());
    }

    @Override
    public void move() {
        if(getAngle() == 0) {
            super.move();
            storage.setLocation(getPosition());
            for (var car: storage.getCars()) {
                car.setLocation(getPosition());
            }
        }
    }

    public void loadCar(T car, ArrayList<T> worldCars){
        if (getAngle() == getMaxAngle()) {
            storage.loadCar(car, worldCars);
        } else {
            throw new IllegalArgumentException("Transporter ramp must be down to load cars!");
        }
    }

    public ArrayList<T> getCars () {
        return storage.getCars();
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(0);
        }
    }

    public int getStorageLimit() {
        return storage.getStorageLimit();
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(70);
        }
    }
}
