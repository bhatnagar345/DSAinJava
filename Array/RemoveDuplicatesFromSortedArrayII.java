package Array;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,1,2,3,3};
        int ans = removeDuplicatesFromArray(a);
        for(int i =0;i<ans;i++)
        {
            System.out.print(a[i] + " ");
        }
    }

    private static int removeDuplicatesFromArray(int[] a) {
        int i =0;
        for(int e : a)
        {
            if(i == 0 || i == 1 || a[i-2] != e)
            {
                a[i++] = e;
            }
        }
        return i;
    }
}
