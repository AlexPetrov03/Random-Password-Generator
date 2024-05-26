public class Alphabet {

    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "1234567890";
    public static final String SPECIAL = "!@#$%^&*()-_=+\\/~?";

    private String characters = "";

    public Alphabet(boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialChars) {
        
        if (includeUppercase) {
        	characters += UPPERCASE;
        }
        if (includeLowercase) {
        	characters += LOWERCASE;
        }
        if (includeDigits) {
        	characters += DIGITS;
        }
        if (includeSpecialChars) {
        	characters += SPECIAL;
        }
    }

    public String getCharacters() {
        return characters;
    }
}