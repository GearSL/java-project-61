package hexlet.code;

import java.util.Scanner;

public class Greeting {
    public String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!\nMay I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName);

        return userName;
    }
}
