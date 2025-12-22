package Array;

import java.util.HashMap;
import java.util.Map;

public class PythagoreanTriplet {

    // Function to check if a Pythagorean Triplet exists

    static void solve(int[] a, int n) {

        Map<Integer, Integer> m = new HashMap<>();

        // Store frequency of elements
        for (int i = 0; i < n; i++) {
            m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = a[i] * a[i] + a[j] * a[j];

                int p = (int) Math.sqrt(sum);
                double q = Math.sqrt(sum);

                if (p == q && m.containsKey(p)) {
                    System.out.println(
                            "the triplet is : " + a[i] + " " + a[j] + " " + p
                    );
                    return;
                }
            }
        }

        System.out.println("there is no triplet ");
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 6, 5};
        int n = arr.length;

        solve(arr, n);
    }
}
