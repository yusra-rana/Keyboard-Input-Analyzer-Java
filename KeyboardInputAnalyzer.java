import java.util.Scanner;

public class KeyboardInputAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String input = sc.nextLine();

        int characters = input.length();
        int words = 0;
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        int specialChars = 0;

        String vowelSet = "aeiouAEIOU";

        if (!input.trim().isEmpty()) {
            words = input.trim().split("\\s+").length;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                if (vowelSet.indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                specialChars++;
            }
        }

        System.out.println("\n--- Analysis Result ---");
        System.out.println("Total Characters: " + characters);
        System.out.println("Total Words: " + words);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Special Characters: " + specialChars);

        sc.close();
    }
}
