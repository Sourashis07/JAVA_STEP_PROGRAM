public class StringArrays {

    // Method to find the longest name
    public static String findLongestName(String[] names) {
        String longest = "";
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Method to count how many names start with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        for (String name : names) {
            if (name.toLowerCase().startsWith(Character.toString(letter).toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    // Method to format all names to "Last, First" format
    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i]; // If format doesn't match, leave as is
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};

        // Test findLongestName
        System.out.println("Longest Name: " + findLongestName(students));

        // Test countNamesStartingWith
        System.out.println("Names starting with 'B': " + countNamesStartingWith(students, 'B'));

        // Test formatNames
        String[] formatted = formatNames(students);
        System.out.println("Formatted Names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
