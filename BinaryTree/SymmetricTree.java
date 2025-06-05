package BinaryTree;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//                 1
//                / \
//               2   2
//              / \ / \
//             3  4 4  3
//  output true
//                 1
//                / \
//               2   2
//                \   \
//                 3   3
//  output true
//If both nodes are null → return true
//If only one is null → return false
//If values are different → return false

public class SymmetricTree {

    // Main method to check symmetry
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Helper method to check if two trees are mirrors
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both null → symmetric
        if (t1 == null && t2 == null) return true;

        // One is null → not symmetric
        if (t1 == null || t2 == null) return false;

        // Values must match, and children must be mirrors
        return (t1.val == t2.val) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }

    // Test the function
    public static void main(String[] args) {
        /*
              1
             / \
            2   2
           / \ / \
          3  4 4  3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + isSymmetric(root)); // Output: true
    }
}

