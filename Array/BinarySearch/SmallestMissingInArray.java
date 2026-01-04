package Array.BinarySearch;

public class SmallestMissingInArray {
    static void smallest(int[] a, int low, int high) {

        if (low > high) {
            System.out.println("the smallest missing number is : " + low);
            return;
        }

        int mid = (low + high) / 2;

        if (mid == a[mid]) {
            smallest(a, mid + 1, high);
        } else {
            smallest(a, low, mid - 1);
        }
    }

    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 5, 6, 7};
        smallest(a, 0, a.length - 1);
    }
}
