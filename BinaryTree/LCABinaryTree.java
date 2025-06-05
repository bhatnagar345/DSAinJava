package BinaryTree;


public class LCABinaryTree {

    // Recursive function to find LCA of p and q
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or root matches one of the nodes
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, current node is LCA
        if (left != null && right != null) {
            return root;
        }

        // Else return the non-null node (if found in one subtree)
        return (left != null) ? left : right;
    }

    // Main method with test data
    public static void main(String[] args) {
        /*
                  3
                 / \
                5   1
               / \  / \
              6  2 0   8
                / \
               7   4

            LCA(5,1) = 3
            LCA(5,4) = 5
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);

        p = root.left;        // Node 5
        q = root.left.right.right; // Node 4
        lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}

