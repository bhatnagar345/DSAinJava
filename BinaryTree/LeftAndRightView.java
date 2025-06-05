package BinaryTree;
import java.util.*;

public class LeftAndRightView {
        // Function to return left view of binary tree
        public static List<Integer> leftView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                // Traverse current level
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curr = queue.poll();

                    // First node of level is part of left view
                    if (i == 0) {
                        result.add(curr.val);
                    }

                    if (curr.left != null) queue.offer(curr.left);
                    if (curr.right != null) queue.offer(curr.right);
                }
            }
            return result;
        }

        // Function to return right view of binary tree
        public static List<Integer> rightView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                // Traverse current level
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curr = queue.poll();

                    // Last node of level is part of right view
                    if (i == levelSize - 1) {
                        result.add(curr.val);
                    }

                    if (curr.left != null) queue.offer(curr.left);
                    if (curr.right != null) queue.offer(curr.right);
                }
            }
            return result;
        }

        // Driver code to test both functions
        public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
                     \
                      7
        */
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(6);
            root.right.right.right = new TreeNode(7);

            System.out.println("Left View: " + leftView(root));   // Output: [1, 2, 4, 7]
            System.out.println("Right View: " + rightView(root)); // Output: [1, 3, 6, 7]
        }


}
