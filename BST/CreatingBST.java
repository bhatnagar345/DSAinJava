package BST;


public class CreatingBST {

    private static TreeNode creating( int val, TreeNode head) {
        if(head == null)
        {
            head = new TreeNode(val);
            return head;
        }
        if(head.val > val)
        {
            head.left = creating(val, head.left);
        }else {
            head.right = creating(val, head.right);
        }
        return head;
    }
    private static void postOrderTraversal(TreeNode root) {
        if(root == null)return;

        System.out.print(root.val + "->");
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);

    }
    public static void main(String[] args)
    {
        int[] arr = {10,7,5,9,12,11,15};
        TreeNode root = null;
        for(int i =0;i<arr.length;i++)
        {
           root = creating(arr[i], root);
        }

        postOrderTraversal(root);
    }
}
