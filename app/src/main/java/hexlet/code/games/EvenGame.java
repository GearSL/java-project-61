package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class EvenGame {
    private static final int MAX_NUMBER_GENERATOR = 50;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }

    private static String[][] generateQuestions() {
        String[][] questions = new String[Engine.ROUNDS_COUNT][COLUMNS_COUNT];
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int generatedNumber = generateNumber();
            questions[i][QUESTION_INDEX] = String.format("%d", generatedNumber);
            questions[i][ANSWER_INDEX] = isEven(generatedNumber) ? "yes" : "no";
        }
        return questions;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static int generateNumber() {
        return Utils.generateNumber(1, MAX_NUMBER_GENERATOR);
    }
}
