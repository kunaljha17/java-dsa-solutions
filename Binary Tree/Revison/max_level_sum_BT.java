// using level order traversal BFS to do this ..
// at every level sum rest







class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int ans = 1;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();   
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                sum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
        }

        return ans;
    }
}
