package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
Each packet can have a variable number of chocolates
.There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between
maximum chocolates and minimum chocolates
is 9 - 3 = 6 by choosing following M packets :
{3, 4, 9, 7, 9}.
*/
public class ChoclateDistribution {
    private static void choclate(int[] arr, int n, int m) {
        Arrays.sort(arr);
        int mini = Integer.MAX_VALUE;
        for(int i =0; i < n-m+1;i++)
        {
           int temp = arr[i+m-1] - arr[i];
           if(mini > temp) mini = temp;
        }
        System.out.println("answer is : " + mini);
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int n = arr.length;
        int m = 5;
        choclate(arr, n, m);
    }


}
