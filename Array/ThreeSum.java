package Array;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix the first element one by one
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate 'i' values to avoid repeated triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;                // Left pointer
            int right = nums.length - 1;     // Right pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for 'left'
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for 'right'
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> output = obj.threeSum(nums);
        System.out.println("Unique triplets with sum 0: " + output);
    }
}

