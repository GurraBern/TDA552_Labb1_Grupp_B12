import java.awt.*;
import java.util.Scanner;
import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String input;

        Volvo240 volvo240 = new Volvo240("Volvo240", Color.BLACK, 4, 100);
        Saab95 saab95 = new Saab95("Saab95", Color.RED, 2, 125);

        //Fixa turbo On knapp
        //Fixa separat input controller

        //Fixa så man kan byta bil
        //Testa använda enum
        boolean runGame = true;
        while (runGame) {
            input = sc.nextLine();
            volvo240.move(input);

            if (input.equals("exit")) {
                runGame = false;
            }

            out.println("Current Posistion = " + volvo240.getCurrentPosition());
            out.println("Current Speed = " + volvo240.getCurrentSpeed());
            }
        }
    }
