package BinaryTree;

public class PathSumBinaryTree {

        // Main function to check for path sum
        public static boolean hasPathSum(TreeNode root, int targetSum) {
            // Base case: if the node is null, no path exists
            if (root == null) return false;

            // If it's a leaf node, check if the value equals targetSum
            if (root.left == null && root.right == null)
                return targetSum == root.val;

            // Recursive case: check left and right subtree with updated sum
            int remainingSum = targetSum - root.val;

            return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
        }

        public static void main(String[] args) {
        /*
            Construct the tree:
                  5
                 / \
                4   8
               /   / \
             11   13  4
             / \
            7   2
         */

            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);

            int targetSum = 22;
            System.out.println("Has path sum: " + hasPathSum(root, targetSum)); // Output: true
        }
}

