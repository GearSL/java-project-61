package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    public static final int ROUNDS_COUNT = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void startGame(String rule, String[][] questionAnswerPairs) {
        //Greet our user and ask his name
        System.out.println("Welcome to the Brain Games!\nMay I have your name?");
        String userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        //Introducing the rules
        System.out.println(rule);
        //Starting print questions
        for (String[] question : questionAnswerPairs) {
            System.out.println("Question: " + question[QUESTION_INDEX]);
            String answer = SCANNER.next();

            if (answer.equals(question[ANSWER_INDEX])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer,
                        question[ANSWER_INDEX]);
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", userName);
    }
}
