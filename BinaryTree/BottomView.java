package BinaryTree;

import java.util.*;

class Pair{
    TreeNode node;
    Integer data;
    Pair(TreeNode node, Integer data)
    {
        this.node = node;
        this.data = data;
    }
}

public class BottomView {
    private static void printBottomView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty())
        {
              Pair myPair = queue.poll();
              TreeNode temp = myPair.node;
              Integer data = myPair.data;
              map.put(data,temp.val);
              if(temp.left != null)
              {
                  queue.add(new Pair(temp.left,data-1));
              }
              if(temp.right != null)
              {
                queue.add(new Pair(temp.right,data+1));
              }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }

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
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printBottomView(root);
    }


}
