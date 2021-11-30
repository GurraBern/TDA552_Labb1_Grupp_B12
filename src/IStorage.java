import java.util.ArrayList;

public interface IStorage <T extends Car>{
    void loadCar(T car, ArrayList<Car> worldCars);
    void unloadCar(ArrayList<T> worldCars);

}
