package BST;

public class ValidateBST {

    // Main function to validate BST
    public boolean isValidBST(TreeNode root) {
        // Start with no bounds
        return isValidBST(root, null, null);
    }

    // Helper function with min and max range
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true; // Empty tree is valid

        // Check if current node violates min or max constraint
        if ((node.val <= min) || (node.val >= max))
            return false;

        // Left subtree: max becomes current node's value
        // Right subtree: min becomes current node's value
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
    }

    // Main method to test the function
    public static void main(String[] args) {
        /*
                5
               / \
              3   7
             / \   \
            2   4   8
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        ValidateBST obj = new ValidateBST();
        System.out.println("Is Valid BST: " + obj.isValidBST(root));  // Output: true
    }
}
