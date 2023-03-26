package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int NEEDLE_CORRECT_ANSWERS = 3;
    private final Game game;

    Engine(Game chosenGame) {
        this.game = chosenGame;
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
