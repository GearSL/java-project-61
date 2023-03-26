package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public final class CalcGame implements Game {
    private int operandA;
    private int operandB;
    private char operation;
    private final Scanner scanner = new Scanner(System.in);
    public static final int MAX_NUMBER_GENERATOR = 50;

    @Override
    public String getRules() {
        return "What is the result of the expression?\n";
    }

    @Override
    public String generateQuestion() {
        operandA = generateNumber();
        operandB = generateNumber();
        operation = getOperation();

        return String.format("Question: %d %s %d", operandA, operation, operandB);
    }

    @Override
    public boolean checkAnswer() {
        int correctAnswer = switch (operation) {
            case '+' -> operandA + operandB;
            case '-' -> operandA - operandB;
            case '*' -> operandA * operandB;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        int answer = scanner.nextInt();

        if (answer == correctAnswer) {
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

    private static char getOperation() {
        char[] operations = {'+', '-', '*'};
        Random random = new Random();
        int randomCharId = random.nextInt(0, operations.length - 1);
        return operations[randomCharId];
    }
}
