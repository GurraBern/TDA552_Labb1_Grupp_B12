import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends TruckWithPlatform{
    private int storageLimit;
    private ArrayList<Car> storedCars = new ArrayList<>();

    public CarTransporter(int storageLimit) {
        super("CarTransporter", Color.BLUE, 2, 900, 70);
        this.storageLimit = storageLimit;
    }

    @Override
    public void move() {
        super.move();
        for (var car: storedCars) {
            car.setLocation(getPosition().x, getPosition().y);
        }
    }

    public void loadCar(Car car, ArrayList<Car> worldCars){
        if (getAngle() == getMaxAngle()) {
            var dist = calculateDistance(getPosition(), car.getPosition());
            if (dist <= 3) {
                storedCars.add(car);
                worldCars.remove(car);
            } else {
                throw new IllegalArgumentException("Car is to far away!");
            }

        } else {
            throw new IllegalArgumentException("Transporter ramp must be down to load cars!");
        }
    }

    public void unloadCar(ArrayList<Car> worldCars) {
        if (storedCars.size() > 0) {
            worldCars.add(storedCars.get(storedCars.size()-1));
            storedCars.remove(storedCars.size()-1);
        } else {
            throw new IllegalArgumentException("There are no stored cars to unload");
        }
    }

    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2));
    }

    public int getStorageLimit() {
        return storageLimit;
    }

    public ArrayList<Car> getCars () {
        return storedCars;
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(0);
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            setAngle(70);
        }
    }
}
