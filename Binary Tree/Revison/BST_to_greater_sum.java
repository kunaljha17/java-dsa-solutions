// do a reverse in-order traversal (right → node → left), 
//   you visit nodes from largest to smallest.
//   Keep a running sum of everything visited so far — that running sum is exactly "sum of all nodes greater than the current one." 
//   Add it to the current node, then add the current node's original value into the running sum before moving to the left subtree.
// visit right subtree (larger values)
// runningSum += node.val
// node.val = runningSum
// visit left subtree (smaller values)



class Solution {
    private int runningSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;

        bstToGst(root.right);    
        runningSum += root.val;
        root.val = runningSum;
        bstToGst(root.left);     

        return root;
    }
}
