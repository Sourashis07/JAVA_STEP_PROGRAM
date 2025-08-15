import java.util.*;

public class TextProcessor {

    // Method to clean and validate input
    public static String cleanInput(String input) {
        // Remove extra spaces and convert to proper case
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder properCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                properCase.append(Character.toUpperCase(word.charAt(0)))
                          .append(word.substring(1).toLowerCase())
                          .append(" ");
            }
        }
        return properCase.toString().trim();
    }

    // Method to analyze text
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Find most common character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.replace(" ", "").toLowerCase().toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        // Display statistics
        System.out.println("\n--- Text Analysis ---");
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    // Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();

        // Step 2: Clean input
        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Text: " + cleaned);

        // Step 3: Analyze text
        analyzeText(cleaned);

        // Step 4: Show words in alphabetical order
        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n--- Words in Alphabetical Order ---");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        // Step 5: Search for specific word
        System.out.print("\nEnter a word to search for: ");
        String searchWord = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        System.out.println(found ? "The word is present in the text." : "The word is not found in the text.");

        scanner.close();
    }
}
