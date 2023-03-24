package hexlet.code;

public interface Game {
    String getRules();
    String generateQuestion();

    boolean checkAnswer();
}
