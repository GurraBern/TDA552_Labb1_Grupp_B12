import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String input;

        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();

        ArrayList<Car> worldCars = new ArrayList<Car>();
        worldCars.add(volvo240);
        worldCars.add(saab95);

        Scania scania = new Scania("Scania", Color.BLACK, 2, 900, 70);
        CarTransporter cartransporter = new CarTransporter(5);
        cartransporter.lowerPlatform();

        volvo240.setLocation(3,0);

        cartransporter.loadCar(volvo240, worldCars);
        cartransporter.loadCar(saab95, worldCars);
        cartransporter.unloadCar(worldCars);
        out.println(worldCars);
        cartransporter.unloadCar(worldCars);
        out.println(worldCars);



        /*
        boolean runGame = true;
        while (runGame) {
            input = sc.nextLine();
            volvo240.userInput(input);

            out.println("Current Posistion = " + volvo240.getPosition());
            out.println("Current Speed = " + volvo240.getCurrentSpeed());

            if (input.equals("exit"))
                runGame = false;
        }
         */
    }
}