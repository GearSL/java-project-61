package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public class PrimeGame implements Game {
    Scanner scanner = new Scanner(System.in);
    int generatedNumber;
    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.\n";
    }

    @Override
    public String generateQuestion() {
        generatedNumber = generateNumber();
        return "Question: " + generatedNumber;
    }

    @Override
    public boolean checkAnswer() {
        String correctAnswer;
        if (checkForPrime(generatedNumber)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }

        String answer = scanner.next();

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            return false;
        }
    }

    private int generateNumber() {
        Random random = new Random();
        return random.nextInt(1, 50);
    }

    static boolean checkForPrime(int inputNumber) {
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
