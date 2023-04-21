package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class CalculatorGame {
    private static final int MAX_NUMBER_GENERATOR = 50;
    private static final String RULE = "What is the result of the expression?\n";
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }
    private static String[][] generateQuestions() {
        String[][] questions = new String[Engine.ROUNDS_COUNT][COLUMNS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int operandA = Utils.generateNumber(1, MAX_NUMBER_GENERATOR);
            int operandB = Utils.generateNumber(1, MAX_NUMBER_GENERATOR);
            char operation = getOperation();

            questions[i][QUESTION_INDEX] = String.format("%d %s %d", operandA, operation, operandB);
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

    private static char getOperation() {
        int randomCharId = Utils.generateNumber(0, OPERATIONS.length - 1);
        return OPERATIONS[randomCharId];
    }
}
