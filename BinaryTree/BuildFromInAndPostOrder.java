package BinaryTree;
import java.util.*;
public class BuildFromInAndPostOrder {

        static int postIndex;
        static Map<Integer, Integer> inorderMap = new HashMap<>();

        // Recursive helper to build tree
        public static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
            // Base case: no elements to build the tree
            if (inStart > inEnd) return null;

            // Get root value from postorder using current index
            int rootVal = postorder[postIndex--];
            TreeNode root = new TreeNode(rootVal);

            // Find the index of root in inorder array
            int inIndex = inorderMap.get(rootVal);

            // Build right subtree first (because we’re going backward in postorder)
            root.right = buildTreeHelper(inorder, postorder, inIndex + 1, inEnd);

            // Then build left subtree
            root.left = buildTreeHelper(inorder, postorder, inStart, inIndex - 1);

            return root;
        }

        // Main function
        public static TreeNode buildTree(int[] inorder, int[] postorder) {
            postIndex = postorder.length - 1;
            inorderMap.clear();

            // Build hashmap from inorder values to indices
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
        }

        // Utility to print inorder
        public static void printInorder(TreeNode root) {
            if (root == null) return;
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }

        // Utility to print postorder
        public static void printPostorder(TreeNode root) {
            if (root == null) return;
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.val + " ");
        }

        public static void main(String[] args) {
            int[] inorder =    {9, 3, 15, 20, 7};
            int[] postorder =  {9, 15, 7, 20, 3};

            TreeNode root = buildTree(inorder, postorder);

            System.out.println("Constructed Tree Inorder:");
            printInorder(root); // Should match input inorder

            System.out.println("\nConstructed Tree Postorder:");
            printPostorder(root); // Should match input postorder
        }
    }


