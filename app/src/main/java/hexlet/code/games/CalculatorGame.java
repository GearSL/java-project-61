package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class CalculatorGame {
    private static final int MAX_NUMBER_GENERATOR = 50;
    private static final String RULE = "What is the result of the expression?\n";
    private static final int QUESTIONS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }
    private static String[][] generateQuestions() {
        String[][] questions = new String[QUESTIONS_COUNT][COLUMNS_COUNT];

        for (int i = 0; i < QUESTIONS_COUNT; i++) {
            int operandA = generateNumber();
            int operandB = generateNumber();
            char operation = getOperation();

            questions[i][QUESTION_INDEX] = String.format("Question: %d %s %d", operandA, operation, operandB);
            questions[i][ANSWER_INDEX] = findAnswer(operandA, operandB, operation);
        }
        return questions;
    }

    public static String findAnswer(int operandA, int operandB, char operation) {
        int correctAnswer = switch (operation) {
            case '+' -> operandA + operandB;
            case '-' -> operandA - operandB;
            case '*' -> operandA * operandB;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        return Integer.toString(correctAnswer);
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, MAX_NUMBER_GENERATOR);
    }

    private static char getOperation() {
        Random random = new Random();
        int randomCharId = random.nextInt(0, OPERATIONS.length - 1);
        return OPERATIONS[randomCharId];
    }
}
