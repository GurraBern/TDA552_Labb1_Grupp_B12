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
        CarTransporter<Car> cartransporter = new CarTransporter<>(2);

        ArrayList<Car> worldCars = new ArrayList<Car>();
        worldCars.add(volvo240);
        worldCars.add(saab95);

        cartransporter.lowerPlatform();
        cartransporter.loadCar(volvo240, worldCars);
        cartransporter.raisePlatform();

        cartransporter.startButton();
        cartransporter.gas(1);
        cartransporter.move();
        cartransporter.gas(1);
        cartransporter.move();
        cartransporter.gas(1);
        cartransporter.move();
        cartransporter.gas(1);

        volvo240.startButton();
        volvo240.gas(1);
        volvo240.move();
        volvo240.gas(1);
        volvo240.move();

        out.println(cartransporter.getPosition());
        out.println(volvo240.getPosition());

        //ArrayList<Car> carlist = cartransporter.getCars();
        //out.println(carlist.get(0).getPosition());

        /*
        Workshop workshop = new Workshop(2, new Point(0,0));
        Workshop<Volvo240> workshopVolvo240 = new Workshop(2, new Point(0,0));
        workshop.loadCar(saab95, worldCars);
        */

        //out.println(workshop.getCars());





        /*
        Scania scania = new Scania("Scania", Color.BLACK, 2, 900, 70);
        CarTransporter cartransporter = new CarTransporter(5);
        cartransporter.lowerPlatform();
        out.println(cartransporter.getStorageLimit());

        volvo240.setLocation(new Point(3,0));
        volvo240.turnLeft();
        */


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