package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreatingBinaryTree {
    private static void creatingTree(TreeNode node) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the root value : ");
        int num = sc.nextInt();
        node.val = num;
        node.left = null;
        node.right = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            TreeNode p = queue.poll();
            System.out.println("Give left value of " + ": " + p.val);
            int a = sc.nextInt();
            if(a != -1)
            {
                TreeNode temp = new TreeNode(a);
                p.left = temp;
                queue.add(temp);
            }
            System.out.println("Give right value of " + ": " + p.val);
            a = sc.nextInt();
            if(a != -1)
            {
                TreeNode temp = new TreeNode(a);
                p.right = temp;
                queue.add(temp);
            }
        }
    }
    static void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args)
    {
        TreeNode node = new TreeNode();
        creatingTree(node);
        inOrder(node);
    }



}
