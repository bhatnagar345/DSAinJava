package BinaryTree;

public class CountAndHeight {
    public static int countNode(TreeNode node)
    {
        if(node == null) return 0;
        int x = countNode(node.left);
        int y = countNode(node.right);
        return x + y +1;
    }
    private static int heightOfTree(TreeNode root) {
        if(root == null) return 0;
        int x = heightOfTree(root.left);
        int y = heightOfTree(root.right);
        if(x > y) return x+1;
        else return y+1;
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
        root.right.right = new TreeNode(6);

        System.out.println("total count of node : " + countNode(root));
        System.out.println("total Height of Tree : " + heightOfTree(root));
    }


}
