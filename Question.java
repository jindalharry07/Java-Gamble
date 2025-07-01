package Project;

import java.util.Scanner;

public class Question {
    private String question;
    private String[] options;
    private int correctAnswer; // 1-based index

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer (1-4): ");
        int answer = sc.nextInt();
        return answer == correctAnswer;
    }
}
