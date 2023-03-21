package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void start(String userName) {
        int correctAnswers = 0;
        boolean checkedResult;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        do {
            int generatedNumber = generateNumber();
            System.out.println("Question: " + generatedNumber);
            String answer = scanner.next();
            checkedResult = checkAnswer(answer, generatedNumber);

            if (checkedResult) {
                correctAnswers++;
            } else {
                return;
            }

        } while (correctAnswers < 3);

        System.out.printf("Congratulations, %s!\n", userName);
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, 50);
    }

    private static Boolean checkAnswer(String answer, int number) {
        String correctAnswer;

        if (number % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            return false;
        }
    }
}
