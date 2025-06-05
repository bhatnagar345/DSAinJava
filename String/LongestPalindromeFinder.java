package String;

import java.util.Scanner;

public class LongestPalindromeFinder {

    // Method to find the longest palindromic substring in a given string
    public static String longestPalin(String S) {
        int n = S.length();  // Get the length of the string
        int len = 1;         // Initialize length of longest palindrome to 1
        int start = 0;       // Start index of longest palindrome

        // Iterate through all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                boolean isPalindrome = true;  // Flag to check if substring is a palindrome

                // Check if substring from index i to j is a palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (S.charAt(i + k) != S.charAt(j - k)) {
                        isPalindrome = false;  // Not a palindrome
                        break;
                    }
                }

                // If it is a palindrome and its length is greater than current max
                if (isPalindrome && (j - i + 1) > len) {
                    start = i;           // Update start index
                    len = j - i + 1;     // Update length of the longest palindrome
                }
            }
        }

        // Extract the longest palindrome substring from the input string
        return S.substring(start, start + len);
    }

    public static void main(String[] args) {

        // 🔹 Hardcoded Test Case
        String test1 = "babad";
        System.out.println("Hardcoded Test:");
        System.out.println("Input: " + test1);
        System.out.println("Longest Palindromic Substring: " + longestPalin(test1));

        // 🔹 Another Hardcoded Test
        String test2 = "forgeeksskeegfor";
        System.out.println("\nAnother Test:");
        System.out.println("Input: " + test2);
        System.out.println("Longest Palindromic Substring: " + longestPalin(test2));

        // 🔹 User Input Test
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a string to find its longest palindromic substring:");
        String input = sc.nextLine();
        System.out.println("Longest Palindromic Substring: " + longestPalin(input));

        sc.close();
    }
}
