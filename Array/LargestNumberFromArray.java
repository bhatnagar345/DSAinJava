package Array;

import java.util.Arrays;
import java.util.Comparator;

//Given an array of non-negative integers nums,
//arrange them such that they form the largest number and return it as a string.
//Input: nums = [3, 30, 34, 5, 9]
//Output: "9534330"


public class LargestNumberFromArray {

    public String largestNumber(int[] nums) {
        // Convert all integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: sort based on which combination is larger
        Arrays.sort(strNums, (String a, String b) -> {
                String order1 = a + b; // "a" followed by "b"
                String order2 = b + a; // "b" followed by "a"
                return order2.compareTo(order1); // descending order

        });

        // Edge case: if the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the final largest number
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }

        return Arrays.toString(strNums);
    }

    // Test with main method
    public static void main(String[] args) {
        LargestNumberFromArray obj = new LargestNumberFromArray();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + obj.largestNumber(nums)); // Output: 9534330
    }
}

