package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public final class GCDGame implements Game {
    private int firstNumber;
    private int secondNumber;
    public static final int MAX_NUMBER_GENERATOR = 50;
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.\n";
    }

    @Override
    public String generateQuestion() {
        firstNumber = generateNumber();
        secondNumber = generateNumber();
        return String.format("Question: %d %d", firstNumber, secondNumber);
    }

    @Override
    public boolean checkAnswer() {
        int correctAnswer = 1;
        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                correctAnswer = i;
            }
        }

        int answer = scanner.nextInt();

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            return false;
        }
    }

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, MAX_NUMBER_GENERATOR);
    }
}
