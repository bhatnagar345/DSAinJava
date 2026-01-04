package Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique
//combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique
//if the frequency of at least one of the chosen numbers is different.
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150
//combinations for the given input.
//        Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), target, nums, 0);
        return ans;
    }

    public static void backTrack(List<List<Integer>> ans, List<Integer> temp,int remain, int[] nums, int start){
        if(remain < 0)return;
        else if(remain == 0){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i = start; i < nums.length ; i++)
            {
                temp.add(nums[i]);
                backTrack(ans, temp,remain - nums[i], nums, i);
                temp.remove(temp.size() -1);
            }

        }

    }
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum(nums, target);
        for(List<Integer> a : ans)
        {
            System.out.println(a);
        }
    }
}
