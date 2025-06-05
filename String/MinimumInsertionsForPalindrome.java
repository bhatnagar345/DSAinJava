package String;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumInsertionsForPalindrome {

    // Method to find the minimum insertions required to make the string a palindrome
    public static int minimum(String s) {
        // Create a map to count the frequency of each character in the string
        HashMap<Character, Integer> m = new HashMap<>();
        int n = s.length();  // Get the length of the string

        // Count the frequency of each character
        for (int i = 0; i < n; i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean flag = true;  // Flag to check when we encounter the first character with odd frequency
        int count = 0;  // Variable to keep track of the number of insertions

        // Iterate through the string to find characters with odd frequencies
        for (int i = 0; i < n; i++) {
            // If flag is true, we are looking for the first odd character
            if (flag) {
                if (m.get(s.charAt(i)) % 2 != 0) {
                    // If the frequency of the character is odd, set flag to false
                    flag = false;
                    m.put(s.charAt(i), 0);  // Mark this character as processed
                }
            } else {
                // If flag is false, we are looking for additional odd characters
                if (m.get(s.charAt(i)) % 2 != 0) {
                    count++;  // Increment the number of insertions required
                    m.put(s.charAt(i), 0);  // Mark this character as processed
                }
            }
        }

        return count;  // Return the number of insertions required
    }

    public static void main(String[] args) {
        // 🔹 Hardcoded Test Case
        String test1 = "abcdefgh";
        System.out.println("Hardcoded Test Input: " + test1);
        System.out.println("Minimum Insertions for Palindrome: " + minimum(test1));

        // 🔹 Another Test Case
        String test2 = "abcabc";
        System.out.println("\nTest Input: " + test2);
        System.out.println("Minimum Insertions for Palindrome: " + minimum(test2));

        // 🔹 User Input Test Case
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a string to find minimum insertions for palindrome:");
        String input = sc.nextLine();
        System.out.println("Minimum Insertions for Palindrome: " + minimum(input));

        sc.close();
    }
}
