import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class CarTransporterTest {
    CarTransporter carTransporter;
    ArrayList<Car> worldCars = new ArrayList<Car>();

    @Before
    public void init() {
        carTransporter = new CarTransporter(5);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        worldCars.add(volvo240);
        worldCars.add(saab95);
        carTransporter.lowerPlatform();
        carTransporter.loadCar(volvo240, worldCars);
        carTransporter.loadCar(saab95, worldCars);
    }

    @Test
    public void CarTransporterGas() {
        carTransporter.startButton();
        carTransporter.gas(1);

        carTransporter.move();
        assertEquals(1, carTransporter.getCurrentSpeed(), 0.2);
    }

    @Test
    public void LoadCar() {
        Volvo240 volvo240 = new Volvo240();
        carTransporter.lowerPlatform();
        carTransporter.loadCar(volvo240, worldCars);
        assertEquals(3, carTransporter.getCars().size());
    }

    @Test
    public void LowerPlatform () {
        carTransporter.lowerPlatform();
        assertEquals(carTransporter.getMaxAngle(), carTransporter.getAngle());
    }

    @Test
    public void RaisePlatform () {
        carTransporter.raisePlatform();
        assertEquals(0, carTransporter.getAngle());
    }

    @Test
    public void GetStorageLimit () {
        carTransporter.getStorageLimit();
        assertEquals(5, carTransporter.getStorageLimit());
    }

    @Test
    public void LoadCarDistanceError() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.setLocation(new Point(5,0));
        carTransporter.lowerPlatform();
        carTransporter.loadCar(volvo240, worldCars);
        assertEquals(2, carTransporter.getCars().size());
    }

    @Test
    public void LoadCarAngleError() {
        Volvo240 volvo240 = new Volvo240();
        carTransporter.raisePlatform();
        carTransporter.loadCar(volvo240, worldCars);
        assertEquals(2, carTransporter.getCars().size());
    }

    @Test
    public void UnloadEmptyStorageError() {
        carTransporter.unloadCar(worldCars);
        carTransporter.unloadCar(worldCars);
        carTransporter.unloadCar(worldCars);
        assertEquals(0, carTransporter.getCars().size());
    }
}
