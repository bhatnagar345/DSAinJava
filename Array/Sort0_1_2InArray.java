package Array;

public class Sort0_1_2InArray {
    static void sort012(int[] a, int n) {

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            switch (a[mid]) {

                case 0:
                    // swap a[mid] and a[low]
                    int temp0 = a[mid];
                    a[mid] = a[low];
                    a[low] = temp0;

                    mid++;
                    low++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // swap a[mid] and a[high]
                    int temp2 = a[mid];
                    a[mid] = a[high];
                    a[high] = temp2;

                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n = arr.length;

        sort012(arr, n);

        for (int elm : arr) {
            System.out.print(elm + " ");
        }

        System.out.println();
        System.out.println();
    }
}
