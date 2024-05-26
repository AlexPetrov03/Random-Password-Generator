public class Password {
    private final String value;
    private final int length;

    public Password(String s) {
        this.value = s;
        this.length = s.length();
    }

    private int getCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            return 1; // Uppercase letter
        } else if (c >= 'a' && c <= 'z') {
            return 2; // Lowercase letter
        } else if (c >= '0' && c <= '9') {
            return 3; // Digit
        } else {
            return 4; // Symbol
        }
    }

    private int evaluateStrength() {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        int score = 0;

        for (int i = 0; i < value.length(); i++) {
            int charType = getCharType(value.charAt(i));

            switch (charType) {
                case 1 -> hasUpper = true;
                case 2 -> hasLower = true;
                case 3 -> hasDigit = true;
                case 4 -> hasSymbol = true;
            }
        }

        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        if (length >= 8) score++;
        if (length >= 16) score++;

        return score;
    }

    public String calculateScore() {
        int score = evaluateStrength();

        return switch (score) {
            case 6 -> "Very Strong";
            case 4, 5 -> "Strong";
            case 3 -> "Medium";
            default -> "Weak";
        };
    }

    @Override
    public String toString() {
        return value;
    }
}