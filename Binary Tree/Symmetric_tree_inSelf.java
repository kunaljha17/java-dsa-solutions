class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetry(root.left , root.right);

    }
    public boolean symmetry(TreeNode t1, TreeNode t2){
        if(t1==null && t2== null) return true;
        if(t1==null || t2== null ||t1.val !=t2.val) return false;
        
        boolean left = symmetry(t1.left,t2.right);
        boolean right = symmetry(t1.right , t2.left);
        
        return left && right;
    }
}
