package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i =0; i < numbers.length;i++)
        {
            int a = target - numbers[i];
            // a = Math.abs(a);
            if(map.containsKey(a))
            {
                ans[0] = i+1;
                ans[1] = map.get(a) + 1;
                Arrays.sort(ans);
            }
            map.put(numbers[i], i);
        }
        for(int i =0;i<ans.length;i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}
