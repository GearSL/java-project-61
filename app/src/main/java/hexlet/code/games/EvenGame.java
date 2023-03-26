package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public final class EvenGame implements Game {
    private int generatedNumber;
    public static final int MAX_NUMBER_GENERATOR = 50;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        this.generatedNumber = generateNumber();

        return "Question: " + this.generatedNumber;
    }

    @Override
    public boolean checkAnswer() {
        String correctAnswer;

        if (generatedNumber % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }

        var answer = scanner.next();

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            return false;
        }
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, MAX_NUMBER_GENERATOR);
    }
}
