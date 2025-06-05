package BinaryTree;

public class DiameterOfBinaryTree {

    // Class variable to keep track of maximum diameter
    static int maxDiameter = 0;

    // Helper function to calculate height and update diameter
    public static int height(TreeNode root) {
        if (root == null) return 0;

        // Recursively get height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Diameter at this node is leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height to parent call
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Main function to return diameter
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;  // Reset before computing
        height(root);
        return maxDiameter;
    }

    // Main method to test the code
    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \
              4   5

            Longest path: 4 -> 2 -> 5 → length = 3 edges
            So, output = 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}

