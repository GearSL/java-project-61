package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NEEDLE_CORRECT_ANSWERS = 3;
    Game game;

    Engine(Game game) {
        this.game = game;
    }

    public void start() {
        int correctAnswers = 0;
        boolean checkedResult;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!\nMay I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(game.getRules());

        do {
            System.out.println(game.generateQuestion());

            checkedResult = game.checkAnswer();

            if (checkedResult) {
                correctAnswers++;
            } else {
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }

        } while (correctAnswers < NEEDLE_CORRECT_ANSWERS);

        System.out.printf("Congratulations, %s!\n", userName);
    }

}
