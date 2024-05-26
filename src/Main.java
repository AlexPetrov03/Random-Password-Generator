import java.util.Scanner;

public class Main {

    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}