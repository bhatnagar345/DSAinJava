package String;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToDecimal {

    // Function to convert Roman numeral to integer
    public static int romanToDecimal(String s) {
        // Map to store the Roman numeral and their corresponding integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        // Traverse through the Roman numeral string
        for (int i = 0; i < s.length(); i++) {
            // Get the value of the current Roman character
            int currentValue = romanMap.get(s.charAt(i));

            // If not the last character and the next character is greater,
            // subtract the current value from the result (subtractive notation)
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        // Return the final result
        return result;
    }

    // Main method to test the function with user input and other test cases
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input Roman numeral string
        System.out.print("Enter a Roman numeral: ");
        String input = sc.nextLine().toUpperCase();

        // Call the function and print the result
        int result = romanToDecimal(input);
        System.out.println("Decimal value: " + result);

        // Additional test cases
        System.out.println("Test Case 1: " + romanToDecimal("IX"));   // Expected: 9
        System.out.println("Test Case 2: " + romanToDecimal("LVIII")); // Expected: 58
        System.out.println("Test Case 3: " + romanToDecimal("MCMXCIV")); // Expected: 1994
        System.out.println("Test Case 4: " + romanToDecimal("III"));   // Expected: 3
    }
}

