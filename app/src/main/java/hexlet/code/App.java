package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit");

        int userSelection = scanner.nextInt();
        Greeting greeting = new Greeting();

        switch (userSelection) {
            case 1 -> greeting.greet();
            case 2 -> EvenGame.start(greeting.greet());
            case 0 -> {
                System.out.println("Thank you for your attention!");
                scanner.close();
            }
            default -> System.out.println("Try again please!");
        }
    }
}
