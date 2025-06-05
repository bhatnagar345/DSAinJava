package BinaryTree;

import java.util.*;
//input
//                 1
//                / \
//               2   3
//              / \   \
//             4   5   6
// Output
//        [
//        [4, 5, 6],
//        [2, 3],
//        [1]
//        ]


public class ReverseLevelOrderTraversal {

    // Main function to return reverse level order traversal as List<List<Integer>>
    public static List<List<Integer>> reverseLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Standard BFS loop
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Remove node from queue
                currentLevel.add(node.val);   // Add its value to current level list

                // Add left and right children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add this level at the front of the result to reverse the order
            result.addFirst(currentLevel);
        }

        return result;
    }

    // Main method with test
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> output = reverseLevelOrder(root);
        System.out.println("Reverse Level Order Traversal: " + output);
    }
}

