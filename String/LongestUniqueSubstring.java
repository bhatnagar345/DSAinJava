package String;

import java.util.HashSet;
import java.util.Scanner;

public class LongestUniqueSubstring {

    // Function to return the length of longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to store characters in current window
        HashSet<Character> set = new HashSet<>();

        int maxLength = 0; // To store max length of substring
        int start = 0;     // Left boundary of sliding window

        // Loop through each character using end pointer
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If duplicate is found, shrink the window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(start)); // remove the character at start
                start++;                     // move start forward
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maxLength if current window is larger
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength; // return the result
    }

    // Main method to test with user input and test cases
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // User input
//        System.out.print("Enter a string: ");
//        String input = sc.nextLine();
//
//        // Result from user input
//        int result = lengthOfLongestSubstring(input);
//        System.out.println("Length of longest substring without repeating characters: " + result);

        // Additional test cases
        System.out.println("Test Case 1: " + lengthOfLongestSubstring("abcbacbb")); // Expected: 3 ("abc")
        System.out.println("Test Case 2: " + lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")
        System.out.println("Test Case 3: " + lengthOfLongestSubstring("pwwkew"));   // Expected: 3 ("wke")
        System.out.println("Test Case 4: " + lengthOfLongestSubstring(""));         // Expected: 0
    }
}
