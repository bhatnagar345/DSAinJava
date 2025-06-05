package BinaryTree;

//✅ Problem Statement (Leetcode 114)
//Given the root of a binary tree, flatten the tree into a "linked list":
//The "linked list" should use the right child pointers in place of next pointers.
//The left child pointers should be set to null.
//The linked list should follow the same order as a pre-order traversal.
//INPUT
//               1
//              / \
//              2   5
//             / \   \
//            3   4   6
//Output
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
public class FlattenBinaryTree {
    static TreeNode prev = null; // to track the previous node in reverse preorder

    public static void flatten(TreeNode root) {
        // Base case
        if (root == null) return;

        // Recurse right first
        flatten(root.right);

        // Then recurse left
        flatten(root.left);

        // Rewiring
        root.right = prev;   // connect current node's right to previous node
        root.left = null;    // make sure left is null (linked list)
        prev = root;         // update previous node to current
    }

    // Helper to print the flattened tree
    public static void printFlattened(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
            Tree:
                  1
                 / \
                2   5
               / \   \
              3   4   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.print("Flattened tree (preorder): ");
        printFlattened(root); // Output: 1 2 3 4 5 6
    }
}

