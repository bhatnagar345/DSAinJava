package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class AllTraversal {
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print(root.val + "->");
        while(!queue.isEmpty())
        {
            TreeNode prev = queue.poll();
            if(prev.left != null)
            {
                System.out.print(prev.left.val + "->");
                queue.add(prev.left);
            }
            if(prev.right != null)
            {
                System.out.print(prev.right.val + "->");
                queue.add(prev.right);
            }
        }
    }

    private static void preOrder(TreeNode root) {
        if(root != null)
        {
            System.out.print(root.val + "->");
            preOrder((root.left));
            preOrder(root.right);
        }
    }

    private static void postOrder(TreeNode root) {
        if(root != null)
        {
            postOrder((root.left));
            postOrder(root.right);
            System.out.print(root.val + "->");
        }
    }

    private static void inOrder(TreeNode root) {
        if(root != null)
        {
            inOrder((root.left));
            System.out.print(root.val + "->");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \   \
              4   5   6

            Expected Vertical Sums:
            HD -2 → 4
            HD -1 → 2
            HD  0 → 1 + 5 = 6
            HD +1 → 3
            HD +2 → 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Pre Order Traversal :");
        preOrder(root);
        System.out.println("null");
        System.out.println("Post Order Traversal :");
        postOrder(root);
        System.out.println("null");
        System.out.println("In Order Traversal :");
        inOrder(root);
        System.out.println("null");
        System.out.println("Level Order Traversal :");
        levelOrder(root);
        System.out.println("null");
    }


}
