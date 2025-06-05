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
//        [1],
//        [3,2],
//        [4, 5, 6],
//        ]


public class ZigZagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer>temp = new ArrayList();

            for(int i =0;i<size;i++)
            {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            if(flag)
            {
                list.add(temp);
                flag = false;
            }
            else
            {
                Collections.reverse(temp);
                list.add(temp);
                flag = true;
            }
        }
        return list;
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

            List<List<Integer>> output = zigzagLevelOrder(root);
            System.out.println("Reverse Level Order Traversal: " + output);
        }

}
