package String;

import java.util.Scanner;

public class FirstOccurrence {

    // Function to find the index of the first occurrence of a substring in a string (without using indexOf())
    public static int findFirstOccurrence(String str, String subStr) {

// Use indexOf() method to find the index of first occurrence of subStr in str
//        return str.indexOf(subStr);


        int n = str.length();
        int m = subStr.length();

        // If the substring is longer than the main string, it can't exist
        if (m > n) {
            return -1;
        }

        // Loop through the main string
        for (int i = 0; i <= n - m; i++) {
            // Compare the substring starting at index i with the subStr
            int j = 0;
            while (j < m && str.charAt(i + j) == subStr.charAt(j)) {
                j++;
            }

            // If we found a match, return the starting index
            if (j == m) {
                return i;
            }
        }

        // If no match is found, return -1
        return -1;
    }

    // Main method to test the function with user input and other test cases
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input string and substring
        System.out.print("Enter the main string: ");
        String str = sc.nextLine();

        System.out.print("Enter the substring to search for: ");
        String subStr = sc.nextLine();

        // Call the function and print the result
        int result = findFirstOccurrence(str, subStr);
        if (result != -1) {
            System.out.println("First occurrence of substring starts at index: " + result);
        } else {
            System.out.println("Substring not found.");
        }

        // Additional test cases
        System.out.println("Test Case 1: " + findFirstOccurrence("hello world", "world"));  // Expected: 6
        System.out.println("Test Case 2: " + findFirstOccurrence("abcdef", "cd"));       // Expected: 2
        System.out.println("Test Case 3: " + findFirstOccurrence("java programming", "gram")); // Expected: 5
        System.out.println("Test Case 4: " + findFirstOccurrence("openai", "xyz"));    // Expected: -1 (not found)
    }
}


