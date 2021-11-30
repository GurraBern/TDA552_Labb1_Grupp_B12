import java.awt.*;
import java.util.ArrayList;

public class Storage<T extends Car> {
    private int storageLimit;
    private ArrayList<T> storedCars = new ArrayList<>();
    private Point position;

    public Storage(int storageLimit, Point position) {
        this.storageLimit = storageLimit;
        this.position = position;
    }

    public void loadCar(T car, ArrayList worldCars){
        var dist = calculateDistance(position, car.getPosition());
        if (dist <= 3) {
            storedCars.add(car);
            worldCars.remove(car);
        } else {
            throw new IllegalArgumentException("Car is to far away!");
        }
    }

    public void setLocation(Point position) {
        this.position = position;
    }

    public void unloadCar(ArrayList worldCars) {
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

    public ArrayList<T> getCars () {
        return storedCars;
    }
}
