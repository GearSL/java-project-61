package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class ProgressionGame {
    public static final int PROGRESSION_LENGTH = 10;
    public static final int MAX_PROGRESSION_RATE = 10;
    private static final int QUESTIONS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "What number is missing in the progression?\n";

    public static void start() {
        String[][] questions = generateQuestions();
        Engine.startGame(RULE, questions);
    }

    private static String[][] generateQuestions() {
        Random random = new Random();
        String[][] questions = new String[QUESTIONS_COUNT][COLUMNS_COUNT];

        for(int i = 0; i < QUESTIONS_COUNT; i++) {
            int progressionRate = random.nextInt(1, MAX_PROGRESSION_RATE);
            int[] generatedProgression = generateProgression(PROGRESSION_LENGTH, progressionRate);
            int idxToMask = random.nextInt(0, generatedProgression.length - 1);
            questions[i][QUESTION_INDEX] = "Question: " + maskProgressionString(generatedProgression, idxToMask);
            questions[i][ANSWER_INDEX] = Integer.toString(generatedProgression[idxToMask]);
        }
        return questions;
    }

    private static int[] generateProgression(int progressionLength, int progressionRate) {
        int[] progression = new int[progressionLength];
        progression[0] = progressionRate;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + progressionRate;
        }

        return progression;
    }

    private static String maskProgressionString(int[] progression, int indexToMask) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length - 1; i++) {
            if (i == indexToMask) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[i]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
