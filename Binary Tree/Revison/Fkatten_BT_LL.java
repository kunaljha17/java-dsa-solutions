//Approach 1

// using tail for store lastNode...
// this method is optimal 


class Solution {
    private TreeNode tail = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (tail != null) {
            tail.left = null;
            tail.right = root;
        }
        tail = root;

        flatten(left);
        flatten(right);
    }
}

//Approach 2

// save both children first, recursively flatten each independently, then stitch: root -> flattened(left) -> flattened(right)
public void flatten(TreeNode root) {
    if (root == null) return;
    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    flatten(left);
    flatten(right);

    root.right = left;
    TreeNode curr = root;
    while (curr.right != null) curr = curr.right;
    curr.right = right;
}
