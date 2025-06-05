package String;

import java.util.Scanner;

public class ReverseWords {

    // Function to reverse the words in a string
    public static String reverseWords(String s) {
        // Trim the string to remove leading/trailing spaces
        s = s.trim();

        // Split the string into an array of words using space as delimiter
        String[] words = s.split("\\s+");

        // StringBuilder to store the reversed words
        StringBuilder reversedString = new StringBuilder();

        // Iterate over the words in reverse order and append to StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);

            // Add space between words, except after the last word
            if (i > 0) {
                reversedString.append(" ");
            }
        }

        // Return the reversed string
        return reversedString.toString();
    }

    // Main method to test the function with user input and other test cases
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call the function and print the result
        String result = reverseWords(input);
        System.out.println("String after reversing words: " + result);

        // Additional test cases
        System.out.println("Test Case 1: " + reverseWords("Hello World!"));       // Expected: "World! Hello"
        System.out.println("Test Case 2: " + reverseWords("   Java is great   ")); // Expected: "great is Java"
        System.out.println("Test Case 3: " + reverseWords("a b c d e"));           // Expected: "e d c b a"
        System.out.println("Test Case 4: " + reverseWords("  SingleWord  "));      // Expected: "SingleWord"
    }
}
