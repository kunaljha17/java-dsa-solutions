class Solution {
    public int SearchRoot(int[] inorder, int left, int right, int val) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }

    public TreeNode tree(int[] preorder, int[] inorder, int[] preIdx, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIdx[0]];
        TreeNode newNode = new TreeNode(rootVal);
        preIdx[0]++;

        int inIdx = SearchRoot(inorder, left, right, rootVal);

        newNode.left = tree(preorder, inorder, preIdx, left, inIdx - 1);
        newNode.right = tree(preorder, inorder, preIdx, inIdx + 1, right);

        return newNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIdx = {0};
        return tree(preorder, inorder, preIdx, 0, preorder.length - 1);
    }
}
