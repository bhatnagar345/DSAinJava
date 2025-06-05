package BinaryTree;

/*
                 1
                / \
               2   3
              / \
             4   5

           Inorder: 4 2 5 1 3
           Successor of 5 is 1
           Successor of 4 is 2
           Successor of 3 is null
       */
public class InorderSuccessorBinaryTree {

    // Class variable to store the result
    static TreeNode successor = null;
    static boolean found = false;

    // Helper function for inorder traversal
    public static void inorder(TreeNode root, TreeNode target) {
        if (root == null || successor != null) return;

        // Traverse left subtree
        inorder(root.left, target);

        // If previous node was target, current node is successor
        if (found && successor == null) {
            successor = root;
            return;
        }

        // If current node is the target, mark as found
        if (root == target) {
            found = true;
        }

        // Traverse right subtree
        inorder(root.right, target);
    }

    // Main function to find inorder successor
    public static TreeNode findInorderSuccessor(TreeNode root, TreeNode target) {
        successor = null;
        found = false;
        inorder(root, target);
        return successor;
    }

    // Main method to test the code
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode target = root.left.right; // Node 5
        TreeNode result = findInorderSuccessor(root, target);

        if (result != null)
            System.out.println("Inorder successor of " + target.val + " is " + result.val);
        else
            System.out.println("No inorder successor found for " + target.val);
    }
}

