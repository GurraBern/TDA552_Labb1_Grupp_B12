import java.util.Scanner;
import static java.lang.System.out;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String input;

        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();

        boolean runGame = true;
        while (runGame) {
            input = sc.nextLine();
            volvo240.move(input);

            out.println("Current Posistion = " + volvo240.getCurrentPosition());
            out.println("Current Speed = " + volvo240.getCurrentSpeed());

            if (input.equals("exit"))
                runGame = false;
        }
    }
}