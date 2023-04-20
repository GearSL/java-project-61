package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCDGame {
    private static final int MAX_NUMBER_GENERATOR = 50;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "Find the greatest common divisor of given numbers.\n";

    public static void start() {
        String[][] questions = generateQuestions(Engine.ROUNDS_COUNT);
        Engine.startGame(RULE, questions);
    }

    private static String[][] generateQuestions(int roundsCount) {
        String[][] questions = new String[roundsCount][COLUMNS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int firstNumber = generateNumber();
            int secondNumber = generateNumber();
            questions[i][QUESTION_INDEX] = String.format("%d %d", firstNumber, secondNumber);
            questions[i][ANSWER_INDEX] = Integer.toString(findGCD(firstNumber, secondNumber));
        }
        return questions;
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        int correctAnswer = 1;
        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                correctAnswer = i;
            }
        }
        return correctAnswer;
    }

    private static int generateNumber() {
        return Utils.generateNumber(1, MAX_NUMBER_GENERATOR);
    }
}
