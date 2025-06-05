package BinaryTree;

import java.util.*;

public class VerticalSumBinaryTree {

    // DFS helper to compute vertical sums
    public static void verticalSum(TreeNode root, int hd, Map<Integer, Integer> map) {
        if (root == null) return;

        // Recurse for left subtree with hd - 1
        verticalSum(root.left, hd - 1, map);

        // Add current node value to the current HD key
        map.put(hd, map.getOrDefault(hd, 0) + root.val);

        // Recurse for right subtree with hd + 1
        verticalSum(root.right, hd + 1, map);
    }

    // Main method to compute and print vertical sums
    public static void printVerticalSums(TreeNode root) {
        // TreeMap to keep HDs in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Start DFS from root with HD = 0
        verticalSum(root, 0, map);

        // Print the vertical sums
        System.out.println("Vertical sums of the tree:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("HD " + entry.getKey() + " → " + entry.getValue());
        }
    }

    // Test the vertical sum with sample data
    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \   \
              4   5   6

            Expected Vertical Sums:
            HD -2 → 4
            HD -1 → 2
            HD  0 → 1 + 5 = 6
            HD +1 → 3
            HD +2 → 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printVerticalSums(root);
    }
}
