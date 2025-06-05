package String;

import java.util.Scanner;

public class DecimalToRoman {

    // Function to convert decimal number to Roman numeral
    public static String decimalToRoman(int num) {
        // Arrays of Roman numerals and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // StringBuilder to construct the Roman numeral
        StringBuilder roman = new StringBuilder();

        // Iterate through the values and symbols arrays
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num, do so and append the symbol
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i]; // Subtract the value from the number
            }
        }

        // Return the final Roman numeral string
        return roman.toString();
    }

    // Main method to test the function with user input and other test cases
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user for input decimal number
        System.out.print("Enter a decimal number: ");
        int input = sc.nextInt();

        // Call the function and print the result
        String result = decimalToRoman(input);
        System.out.println("Roman numeral: " + result);

        // Additional test cases
        System.out.println("Test Case 1: " + decimalToRoman(9));   // Expected: IX
        System.out.println("Test Case 2: " + decimalToRoman(58));  // Expected: LVIII
        System.out.println("Test Case 3: " + decimalToRoman(1994)); // Expected: MCMXCIV
        System.out.println("Test Case 4: " + decimalToRoman(3));   // Expected: III
    }
}

