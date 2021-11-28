import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends TruckWithPlatform{
    private int storageLimit;
    private ArrayList<Vehicle> storedCars = new ArrayList<>();

    public CarTransporter(int storageLimit) {
        super("CarTransporter", Color.BLUE, 2, 900, 70);
        this.storageLimit = storageLimit;
    }

    public void loadNearbyCars(ArrayList<Car> worldCars) {
        if (getAngle() == getMaxAngle()) {
            for (var car: worldCars) {
                if (calculateDistance(getPosition(), car.getPosition()) < 3) {
                    storedCars.add(car);
                }
            }
        } else {
            //Throw exepctions
        }
    }

    public void loadCar(Vehicle vehicle, ArrayList<Vehicle> worldVehicles){
        if (getAngle() == getMaxAngle()) {
            var dist = calculateDistance(getPosition(), vehicle.getPosition());
            if (dist < 3) {
                storedCars.add(vehicle);
                worldVehicles.remove(vehicle);
            }
        } else {
            //Throw exepctions
        }
    }

    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x), 2) + Math.pow((p1.y-p2.y), 2));
    }

    public void unloadCar(int count){
        //TODO add to world again
    }

    public void unloadAllCars(int count){
        //TODO add to world again
    }

    public int getStorageLimit() {
        return storageLimit;
    }


    public int raisePlatform(int currentAngle) {
        if (getCurrentSpeed() == 0) {
            currentAngle = 0;
            return currentAngle;
        }
        //TODO
        return 0;
    }

    public int lowerPlatform(int currentAngle) {
        if (getCurrentSpeed() == 0) {
            currentAngle = 70;
            return currentAngle;
        }
        //TODO Error
        return 0;
    }
}
