package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Game {
    int correctAnswer;
    @Override
    public String getRules() {
        return "What number is missing in the progression?\n";
    }

    @Override
    public String generateQuestion() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int[] generatedProgression = generateProgression();
        int idx = random.nextInt(0, generatedProgression.length - 1);

        for (int i = 0; i < generatedProgression.length - 1; i++) {
            if (i == idx) {
                correctAnswer = generatedProgression[i];
                stringBuilder.append("..");
            } else {
                stringBuilder.append(generatedProgression[i]);
            }
            stringBuilder.append(" ");
        }
        return "Question: " + stringBuilder;
    }

    @Override
    public boolean checkAnswer() {
        Scanner scanner = new Scanner(System.in);
        var answer = scanner.nextInt();

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            return false;
        }

    }

    private int[] generateProgression() {
        Random random = new Random();
        int progressionRate = random.nextInt(1, 10);
        int[] progression = new int[10];

        progression[0] = progressionRate;

        for (int i = 1; i < 10; i++) {
            progression[i] = progression[i - 1] + progressionRate;
        }

        return progression;
    }
}
