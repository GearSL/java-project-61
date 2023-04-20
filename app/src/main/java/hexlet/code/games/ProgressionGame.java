package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public final class ProgressionGame {
    public static final int PROGRESSION_LENGTH = 10;
    public static final int MAX_PROGRESSION_RATE = 10;
    private static final int COLUMNS_COUNT = 2;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static final String RULE = "What number is missing in the progression?\n";

    public static void start() {
        String[][] questions = generateQuestions(Engine.ROUNDS_COUNT);
        Engine.startGame(RULE, questions);
    }

    private static String[][] generateQuestions(int roundsCount) {
        String[][] questions = new String[roundsCount][COLUMNS_COUNT];

        for (int i = 0; i < roundsCount; i++) {
            int progressionRate = Utils.generateNumber(1, MAX_PROGRESSION_RATE);
            int startingValue = Utils.generateNumber(1, MAX_PROGRESSION_RATE);
            String[] generatedProgression = generateProgression(PROGRESSION_LENGTH, progressionRate, startingValue);
            int idxToMask = Utils.generateNumber(0, generatedProgression.length - 1);
            questions[i][QUESTION_INDEX] = maskProgression(generatedProgression, idxToMask);
            questions[i][ANSWER_INDEX] = generatedProgression[idxToMask];
        }
        return questions;
    }

    private static String[] generateProgression(int progressionLength, int progressionRate, int startingValue) {
        String[] progression = new String[progressionLength];
        progression[0] = Integer.toString(startingValue);
        for (int i = 1; i < progression.length; i++) {
            progression[i] = Integer.toString(Integer.parseInt(progression[i - 1]) + progressionRate);
        }
        return progression;
    }

    private static String maskProgression(String[] progression, int indexToMask) {
        String[] result = Arrays.copyOf(progression, progression.length);
        result[indexToMask] = "..";
        return String.join(" ", result);
    }
}
