package BST;

//Given the root of a Binary Search Tree (BST),
//return the minimum absolute difference between the values of any two different nodes in the tree.
public class MinAbsDiffInBST {

    // Previous value and minimum difference are tracked globally
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    // Main function to call
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    // Inorder traversal of BST
    private void inorder(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        inorder(node.left);

        // Process current node
        if (prev != null) {
            int diff = Math.abs(node.val - prev);
            minDiff = Math.min(minDiff, diff);
        }
        prev = node.val; // Update prev

        // Traverse right subtree
        inorder(node.right);
    }

    // Test with sample tree
    public static void main(String[] args) {
        /*
                4
               / \
              2   6
             / \
            1   3
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinAbsDiffInBST obj = new MinAbsDiffInBST();
        int result = obj.getMinimumDifference(root);
        System.out.println("Minimum Absolute Difference: " + result); // Output: 1
    }
}
