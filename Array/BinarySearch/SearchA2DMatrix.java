package Array.BinarySearch;
//You are given an m x n integer matrix matrix with the following two properties:
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//You must write a solution in O(log(m * n)) time complexity.
//
//Example 1:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//
//Example 2:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
public class SearchA2DMatrix {
    private static boolean binarySearchMat(int[] temp, int s, int e, int target) {
        if(e >= s)
        {
            int m = (s+e)/2;
            if(temp[m] == target) return true;
            if(temp[m] < target) return binarySearchMat(temp,m +1, e, target);
            return binarySearchMat(temp,s,m -1, target);
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        for(int[] temp : matrix)
        {
            if(binarySearchMat(temp, 0 , temp.length-1,5))
                System.out.println("True");;
        }
        System.out.println("False");

    }
}
