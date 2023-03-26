package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
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
        Game game;

        switch (userSelection) {
            case 1 -> Cli.greeting();
            case 2 -> {
                game = new EvenGame();
                Engine engine = new Engine(game);
                engine.start();
            }
            case 3 -> {
                game = new CalcGame();
                Engine engine = new Engine(game);
                engine.start();
            }
            case 4 -> {
                game = new GCDGame();
                Engine engine = new Engine(game);
                engine.start();
            }
            case 5 -> {
                game = new ProgressionGame();
                Engine engine = new Engine(game);
                engine.start();
            }
            case 6 -> {
                game = new PrimeGame();
                Engine engine = new Engine(game);
                engine.start();
            }
            case 0 -> {
                System.out.println("Thank you for your attention!");
                scanner.close();
            }
            default -> System.out.println("Try again please!");
        }
    }
}
