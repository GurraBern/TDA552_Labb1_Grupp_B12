import java.util.ArrayList;

public interface IStorage {
    public void loadCar(Car car, ArrayList<Car> worldCars);
    public void unloadCar(ArrayList<Car> worldCars);

}
