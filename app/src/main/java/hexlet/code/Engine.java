package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static String userName;
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void startGame(String rule, String[][] questions) {
        //Greet our user and ask his name
        greet();
        //Introducing the rules
        System.out.println(rule);
        //Starting print questions
        for (String[] question : questions) {
            System.out.println(question[QUESTION_INDEX]);
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

    private static void greet() {
        System.out.println("Welcome to the Brain Games!\nMay I have your name?");
        userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
    }
}
