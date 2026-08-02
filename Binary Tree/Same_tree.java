// Input: p = [1,2,3], q = [1,2,3]
// Output: true
//   Input: p = [1,2], q = [1,null,2]
// Output: false


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q== null){
            return true;
        }
        if(p == null ||q==null||p.val != q.val){
            return false;
        }
      return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
