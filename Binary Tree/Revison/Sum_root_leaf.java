//Approach :
//As you move from a parent node to a child node, the current number shifts one decimal place to the left and adds the child's value:
//Null Node: If the current node is null, it contributes 0 to the total sum.
// Leaf Node: If a node has no left and no right child (node.left == null && node.right == null), the path ends here. Return the accumulated currentNumber.
//For any non-leaf node, recursively compute the sum from the left subtree and right subtree,  
//return dfs(left,currSum) +dfs(right,currSum)


class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
