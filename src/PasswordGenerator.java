import java.util.Scanner;

public class PasswordGenerator {
    private Alphabet alphabet;
    private static Scanner keyboard;

    public PasswordGenerator(Scanner scanner) {
        keyboard = scanner;
    }

    public PasswordGenerator(boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols) {
        alphabet = new Alphabet(includeUppercase, includeLowercase, includeNumbers, includeSymbols);
    }

    public void mainLoop() {
        displayMenu();

        String userChoice = "-1";

        while (!userChoice.equals("4")) {
            userChoice = keyboard.next();

            switch (userChoice) {
                case "1":
                    promptPassword();
                    displayMenu();
                    break;
                case "2":
                    validatePassword();
                    displayMenu();
                    break;
                case "3":
                    showInformation();
                    displayMenu();
                    break;
                case "4":
                    exitMessage();
                    break;
                default:
                    System.out.println();
                    System.out.println("Please choose a valid option");
                    displayMenu();
                    break;
            }
        }
    }

    private Password generatePassword(int length) {
        String password = "";
        String availableChars = alphabet.getCharacters();
        int availableCharsLength = availableChars.length();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * availableCharsLength);
            password += availableChars.charAt(index);
        }

        return new Password(password.toString());
    }

    private void showInformation() {
        System.out.println();
        System.out.println("Tips for creating a strong password:");
        System.out.println("1. Use at least 8 characters, if allowed.");
        System.out.println("2. Include a mix of uppercase, lowercase, numbers, and symbols.");
        System.out.println("3. Generate passwords randomly where possible.");
        System.out.println("4. Avoid reusing passwords across different accounts.");
        System.out.println("5. Steer clear of predictable patterns and easily guessable information.");
    }

    private void promptPassword() {
        boolean includeUppercase = false;
        boolean includeLowercase = false;
        boolean includeNumbers = false;
        boolean includeSymbols = false;

        boolean validSelection;

        System.out.println();
        System.out.println("Please answer the following questions with Yes or No.\n");

        do {
            validSelection = true;

            includeLowercase = promptCharacterInclusion("lowercase letters (a-z)");
            includeUppercase = promptCharacterInclusion("uppercase letters (A-Z)");
            includeNumbers = promptCharacterInclusion("numbers (0-9)");
            includeSymbols = promptCharacterInclusion("symbols (!@#$...)");

            if (!includeUppercase && !includeLowercase && !includeNumbers && !includeSymbols) {
                System.out.println("You need to select at least one character type. Please try again.");
                validSelection = false;
            }
        } while (!validSelection);

        System.out.println("Enter the desired password length:");
        int length = keyboard.nextInt();

        PasswordGenerator generator = new PasswordGenerator(includeUppercase, includeLowercase, includeNumbers, includeSymbols);
        Password password = generator.generatePassword(length);

        System.out.println("Generated password: " + password);
    }

    private boolean promptCharacterInclusion(String charType) {
        String input;
        do {
            System.out.println("Include " + charType + "? (Yes/No)");
            input = keyboard.next();
            if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Please respond with Yes or No.");
            }
        } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

        return input.equalsIgnoreCase("yes");
    }

    private void validatePassword() {
        System.out.print("\nEnter your password: ");
        String input = keyboard.next();

        Password password = new Password(input);
        System.out.println(password.calculateScore());
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("1 - Password Generator");
        System.out.println("2 - Password Strength Check");
        System.out.println("3 - Useful Information");
        System.out.println("4 - Quit");
        System.out.print("Choice: ");
    }

    private void exitMessage() {
        System.out.println("Exiting the program.");
    }
}