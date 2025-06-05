package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreAndInOrder {
        static int preorderIndex = 0;
        static Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        // Recursive helper function
        public static TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd) {
            // Base condition
            if (inStart > inEnd) return null;

            // Get root value from preorder using current index
            int rootVal = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootVal);

            // Get the root index in inorder array
            int inorderIndex = inorderIndexMap.get(rootVal);

            // Build left subtree
            root.left = buildTreeHelper(preorder, inStart, inorderIndex - 1);

            // Build right subtree
            root.right = buildTreeHelper(preorder, inorderIndex + 1, inEnd);

            return root;
        }

        // Main function to call
        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            inorderIndexMap.clear();

            // Map all inorder values to their indices for fast access
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return buildTreeHelper(preorder, 0, inorder.length - 1);
        }

        // Utility to print inorder traversal of the tree
        public static void printInorder(TreeNode root) {
            if (root == null) return;
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }

        // Utility to print preorder traversal
        public static void printPreorder(TreeNode root) {
            if (root == null) return;
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }

        public static void main(String[] args) {
            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};

            TreeNode root = buildTree(preorder, inorder);

            System.out.println("Constructed Tree Inorder:");
            printInorder(root); // Should match input inorder
            System.out.println("\nConstructed Tree Preorder:");
            printPreorder(root); // Should match input preorder
        }
    }


