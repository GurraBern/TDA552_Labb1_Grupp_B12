import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Car volvo240 = new Car("Volvo240", Color.BLACK, 4, 100);
        Saab95 saab95 = new Saab95("Saab95", Color.RED, 2, 125);
        Scanner sc = new Scanner(System.in);
        String input;
        //Dictionary
        Hashtable<String, Integer> moveDictionary = new Hashtable<>();
        //MovementMap
        moveDictionary.put("w", 1);
        //moveDictionary.put("s", -1);
        moveDictionary.put("d", 1);
        moveDictionary.put("a", -1);
        //EngineMap/Start
        moveDictionary.put("y", -1);
        //Rotate Left
        moveDictionary.put("l", -1);
        //Rotate Left
        moveDictionary.put("r", 1);

        boolean runGame = true;
        while (runGame) {
            input = sc.nextLine();
            volvo240.move(input);

            if (volvo240.currentPosition.y == 100) {
                //Stop Game
                runGame = false;
            }

            out.println("Current Posistion = " + volvo240.currentPosition);
            out.println("Current Speed = " + volvo240.getCurrentSpeed());
            }
        }
    }
