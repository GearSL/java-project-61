package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {
    public static final int CLI = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");

        int userSelection = scanner.nextInt();

        switch (userSelection) {
            case CLI -> Cli.greeting();
            case EVEN_GAME -> EvenGame.start();
            case CALC_GAME -> CalculatorGame.start();
            case GCD_GAME -> GCDGame.start();
            case PROGRESSION_GAME -> ProgressionGame.start();
            case PRIME_GAME -> PrimeGame.start();
            case EXIT -> System.out.println("Thank you for your attention!");
            default -> System.out.println("Try again please!");
        }
        scanner.close();
    }
}
