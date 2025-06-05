package BinaryTree;

import java.util.*;

public class K_DistanceFromNode {
    // Step 1: Map to store parent of each node
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    // DFS to populate parent map
    public static void buildParentMap(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parentMap.put(root, parent);
        buildParentMap(root.left, root);
        buildParentMap(root.right, root);
    }

    // Step 2: BFS from target to find nodes at distance K
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Build parent references
        buildParentMap(root, null);

        // Queue for BFS, Set to track visited nodes
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // If we've reached distance k, collect all node values at this level
            if (currentDistance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            // Traverse the next level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check left child
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.add(current.left);
                }

                // Check right child
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.add(current.right);
                }

                // Check parent
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }

            // Increase distance after processing current level
            currentDistance++;
        }

        return result;
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

            Target = 5, k = 2
            Output = [7,4,1]
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

        TreeNode target = root.left; // node 5

        List<Integer> result = distanceK(root, target, 2);
        System.out.println("Nodes at distance 2 from target: " + result);
    }

}
