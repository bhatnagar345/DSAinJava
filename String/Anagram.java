package String;

import java.util.*;

public class Anagram {

    // Function to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // Step 1: If lengths are not equal, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 2: Create a frequency array for 26 lowercase letters
        int[] charCount = new int[26];

        // Step 3: Count frequency from the first string
        for (int i = 0; i < str1.length(); i++) {
            // Increment the count for the character in str1
            charCount[str1.charAt(i) - 'a']++;
        }

        // Step 4: Decrease frequency from the second string
        for (int i = 0; i < str2.length(); i++) {
            // Decrement the count for the character in str2
            charCount[str2.charAt(i) - 'a']--;
        }

        // Step 5: Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;  // If any count is not zero, they are not anagrams
            }
        }

        // If all counts are zero, then they are anagrams
        return true;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test cases
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are NOT anagrams.");
        }

        // Additional test case
        String str3 = "hello";
        String str4 = "world";

        if (areAnagrams(str3, str4)) {
            System.out.println(str3 + " and " + str4 + " are anagrams.");
        } else {
            System.out.println(str3 + " and " + str4 + " are NOT anagrams.");
        }
    }
}
