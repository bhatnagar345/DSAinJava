package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    private static List<Integer> RootToNode(TreeNode root, int i) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(DfsToNode(root,i,ans))return ans;
        return ans;
    }

    private static boolean DfsToNode(TreeNode root, int i, List<Integer> ans) {
        if(root == null) return  false;
        ans.add(root.val);
        if(root.val == i) return true;

        if((DfsToNode(root.left,i,ans)) || DfsToNode(root.right, i, ans)){
            return true;
        }

        ans.remove(ans.size()-1);
        return false;
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
        List<Integer> list = RootToNode(root,5);

        System.out.println(list);
    }


}
