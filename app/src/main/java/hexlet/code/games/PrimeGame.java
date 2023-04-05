package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class PrimeGame {
    public static final int MAX_NUMBER_GENERATOR = 50;
    private static final int QUESTIONS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.\n";

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }
    private static String[][] generateQuestions() {
        String[][] questions = new String[QUESTIONS_COUNT][COLUMNS_COUNT];

        for (int i = 0; i < QUESTIONS_COUNT; i++) {
            int generatedNumber = generateNumber();
            questions[i][QUESTION_INDEX] = "Question: " + generatedNumber;
            questions[i][ANSWER_INDEX] = findAnswer(generatedNumber);
        }
        return questions;
    }

    private static String findAnswer(int number) {
        String correctAnswer;
        if (checkForPrime(number)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return correctAnswer;
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, MAX_NUMBER_GENERATOR);
    }

    private static boolean checkForPrime(int inputNumber) {
        boolean isItPrime = true;

        if (inputNumber <= 1) {
            isItPrime = false;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
        }
        return isItPrime;
    }
}
