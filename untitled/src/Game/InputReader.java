package Game;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;


    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    //Reads inputs from user, thats also checks if user input is incorrect
    public int readInt(String prompt) {
        System.out.println(prompt + ": ");

        while (!scanner.hasNextInt()) {
            System.out.println("Wrong input! Try adding a valid number.");
            scanner.next();
            System.out.println(prompt + ": ");
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public String readString(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public String readWord(String prompt) {
        System.out.println(prompt + ": ");
        String word = scanner.next();
        scanner.nextLine();
        return scanner.next();
    }

    public void close() {
        this.scanner.close();
    }
}
