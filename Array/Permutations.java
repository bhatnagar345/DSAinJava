package Array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    public static void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i =0; i < nums.length ; i++)
            {
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(ans, temp, nums);
                temp.remove(temp.size() -1);
            }

        }

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = permute(nums);
        for(List<Integer> a : ans)
        {
            System.out.println(a);
        }
    }
}
