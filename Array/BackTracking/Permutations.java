package Array.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backTrack(ans, 0, nums);
        return ans;
    }

    public static void backTrack(List<List<Integer>> ans, int idx, int[] nums){
        if(idx == nums.length){
            ans.add(Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList()));;
            return;
        }
        for(int i = idx; i < nums.length;i++)
        {
            swap(nums, i, idx);
            backTrack(ans,idx+1, nums);
            swap(nums,i,idx);

        }

    }

    private static void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans.size());
        for(List<Integer> a : ans)
        {
            System.out.println(a);
        }
    }
}
