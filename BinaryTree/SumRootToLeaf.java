package BinaryTree;

//Input
//             1
//            / \
//           2   3
//Output: 25
//
//Explanation:
//
//Root-to-leaf path 1→2 forms the number 12
//
//Root-to-leaf path 1→3 forms the number 13
//Sum = 12 + 13 = 25

public class SumRootToLeaf {
    static int sum = 0;

    // Main function to be called
    public static int sumNumbers(TreeNode root) {
        if(root != null)
            dfs(root, root.val);
        return sum;
    }

    // Helper DFS function
    public static void dfs(TreeNode root, int currentSum) {
        // Base case
        if(root.left == null && root.right == null)
        {
            sum += currentSum;
        }
        if(root != null)
        {

            if(root.left != null)
                dfs(root.left, currentSum*10 + root.left.val);
            if(root.right != null)
                dfs(root.right, currentSum*10 + root.right.val);
        }
    }

    public static void main(String[] args) {
        /*
             1
            / \
           2   3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + result); // Output: 25
    }
}
