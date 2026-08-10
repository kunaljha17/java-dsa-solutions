//using inorder when left reach to left null then return and store prev val .. and before check that does there is that first and second node 
//by checking prev.val > node.val then assign



class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;       
            }
            second = node;          
        }
        prev = node;
        inorder(node.right);
    }
}
