package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class GCDGame {
    private static final int MAX_NUMBER_GENERATOR = 50;
    private static final int QUESTIONS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "Find the greatest common divisor of given numbers.\n";

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }

    private static String[][] generateQuestions() {
        String[][] questions = new String[QUESTIONS_COUNT][COLUMNS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int firstNumber = generateNumber();
            int secondNumber = generateNumber();
            questions[i][QUESTION_INDEX] = String.format("Question: %d %d", firstNumber, secondNumber);
            questions[i][ANSWER_INDEX] = findAnswer(firstNumber, secondNumber);
        }
        return questions;
    }

    private static String findAnswer(int firstNumber, int secondNumber) {
        int correctAnswer = 1;
        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                correctAnswer = i;
            }
        }
        return Integer.toString(correctAnswer);
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, MAX_NUMBER_GENERATOR);
    }
}
