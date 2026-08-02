// in this we do optimize Bcz no extra space used .
// we know in BST inorder we get sorted arrangement .
//so store prev and minus take min diff .. so on until all nodes ...



class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private int prev = -1;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return; 
        }
        inOrder(root.left);
        if(prev != -1){
            minDiff = Math.min(minDiff,root.val-prev);
        }
        prev = root.val;
        inOrder(root.right);
    }
}
