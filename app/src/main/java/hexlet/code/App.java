package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                1 - Greet
                2 - Even
                3 - Calc
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
            case 0 -> {
                System.out.println("Thank you for your attention!");
                scanner.close();
            }
            default -> System.out.println("Try again please!");
        }
    }
}
