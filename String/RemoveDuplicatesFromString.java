package String;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromString {

    // Method to remove duplicate characters from the string
    public static String removeDuplicates(String s) {
        // Create a HashSet to track unique characters
        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();  // StringBuilder to store the result

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is not in the set, add it to the result and the set
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                result.append(currentChar);  // Add unique character to result
            }
        }

        return result.toString();  // Return the resulting string with unique characters
    }

    public static void main(String[] args) {
        // 🔹 Hardcoded Test Case
        String test1 = "harsh bhatnagar";
        System.out.println("Hardcoded Test Input: " + test1);
        System.out.println("String after removing duplicates: " + removeDuplicates(test1));

        // 🔹 Another Test Case
        String test2 = "geeksforgeeks";
        System.out.println("\nTest Input: " + test2);
        System.out.println("String after removing duplicates: " + removeDuplicates(test2));

        // 🔹 User Input Test Case
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a string to remove duplicates:");
        String input = sc.nextLine();
        System.out.println("String after removing duplicates: " + removeDuplicates(input));

        sc.close();
    }
}
