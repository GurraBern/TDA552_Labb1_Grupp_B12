import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String input;


        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Scania scania = new Scania("Scania", Color.BLACK, 2, 900, 70);
        CarTransporter cartransporter = new CarTransporter(5);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        vehicles.add(volvo240);
        vehicles.add(saab95);


        boolean runGame = true;
        while (runGame) {
            input = sc.nextLine();
            volvo240.userInput(input);

            out.println("Current Posistion = " + volvo240.getPosition());
            out.println("Current Speed = " + volvo240.getCurrentSpeed());

            if (input.equals("exit"))
                runGame = false;
        }
    }
}