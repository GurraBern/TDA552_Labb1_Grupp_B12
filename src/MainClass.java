import java.awt.*;
import java.sql.Time;
import java.time.Clock;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDateTime;

import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        // TODO Remove Volvo240 script
        Car volvo240 = new Car("Volvo240", Color.BLACK, 4, 100);
        Saab95 saab95 = new Saab95("Saab95", Color.RED, 2, 125);
        Scanner sc = new Scanner(System.in);
        //out.println(volvo240.getNrDoors());

        boolean runGame = true;
        String input = sc.nextLine();
        if (Objects.equals(input, "w")) {
            volvo240.startEngine();

        while (runGame) {
            Thread.sleep(250);

            volvo240.move(input);

            //Player Inputs

            /*} else if(input == "s") {
                //sakta ner
            } else if(input == "a") {
                //sväng vänster
            } else if(input == "d") {
                //sväng höger*/
            //}else
            if (volvo240.currentPosition == 100) {
                //Stop Game
                runGame = false;
            }

            out.println("Current Posistion Y = " + volvo240.currentPosition);
            }
        }
    }
}
