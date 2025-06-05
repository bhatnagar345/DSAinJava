package String;

import java.util.Arrays;
import java.util.Scanner;

//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

public class LongestCommonPrefix {

    // Function to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int n = str1.length();
        int i =0;
        while(i < str1.length()  && i < str2.length())
        {
            if(str1.charAt(i) != str2.charAt(i))
            {
                break;
            }
            i++;
        }
        return str1.substring(0,i);
    }

    // Main method to test the function with user input and other test cases
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input string array
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        // Take all strings as input
        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        // Call the function and print the result
        String result = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);

        // Additional test cases
        System.out.println("Test Case 1: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));  // Expected: "fl"
        System.out.println("Test Case 2: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));     // Expected: ""
        System.out.println("Test Case 3: " + longestCommonPrefix(new String[]{"apple", "app", "april"}));     // Expected: "ap"
        System.out.println("Test Case 4: " + longestCommonPrefix(new String[]{"interview", "integrate", "integration"}));  // Expected: "inte"
    }
}

