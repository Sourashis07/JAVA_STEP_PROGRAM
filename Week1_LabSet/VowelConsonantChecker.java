import java.util.Scanner;

public class VowelConsonantChecker {

    // Method to check if a character is vowel, consonant, or not a letter
    public static String checkCharType(char ch) {
        // Convert to lowercase using ASCII logic if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // ASCII conversion
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to find vowels and consonants in a string using charAt()
    public static String[][] findVowelsAndConsonants(String input) {
        String[][] result = new String[input.length()][2];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find vowels and consonants
        String[][] result = findVowelsAndConsonants(input);

        // Display results
        displayResult(result);

        scanner.close();
    }
}
