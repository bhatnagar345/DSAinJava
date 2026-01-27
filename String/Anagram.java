package String;

import java.util.*;

public class Anagram {

    // Function to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCount = new int[52];

        for (char ch : str1.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                charCount[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                charCount[ch - 'a' + 26]++;
            }
        }

        for (char ch : str2.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                charCount[ch - 'A']--;
            } else if (ch >= 'a' && ch <= 'z') {
                charCount[ch - 'a' + 26]--;
            }
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

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
