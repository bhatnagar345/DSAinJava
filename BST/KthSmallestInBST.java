package BST;

//Given the root of a Binary Search Tree and an integer k, return the kth smallest element in the BST.
//
//🔍 Key Insight
//Inorder traversal of a BST yields sorted elements in ascending order.
// So, the kth node visited during inorder traversal is the answer.
public class KthSmallestInBST {

    private int count = 0; // Counter for visited nodes
    private int result = -1; // To store kth smallest value

    // Main function to find kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k); // Start inorder traversal
        return result;
    }

    // Inorder traversal: left -> root -> right
    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        // Traverse left subtree
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse right subtree only if kth not yet found
        inorder(node.right, k);
    }

    // Main method for testing
    public static void main(String[] args) {
        /*
                5
               / \
              3   6
             / \
            2   4
           /
          1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestInBST obj = new KthSmallestInBST();
        int k = 3;
        System.out.println("Kth Smallest Element: " + obj.kthSmallest(root, k));  // Output: 3
    }
}
