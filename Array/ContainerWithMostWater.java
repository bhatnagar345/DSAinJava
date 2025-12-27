package Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,1};
        int ans =0;
        int maxi = 0;
        int i =0;
        int j = height.length -1;
        while(i < j)
        {
            if(height[i] < height[j])
            {
                maxi = Math.max(maxi, height[i]*(j-i));
                i++;
            }else{
                maxi = Math.max(maxi, height[j]*(j-i));
                j--;
            }
            ans = Math.max(maxi,ans);
        }
        System.out.println(ans);
    }
}
