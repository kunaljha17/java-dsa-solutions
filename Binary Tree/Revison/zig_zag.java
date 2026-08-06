// in this we use Queue for normal level order traverse , and Deque for storing one level node in zig zag way ..
// then when when one level complete then store and rest deque ...
// one flag too to track left to right or right to left adding  in deqeue




class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelDeque = new ArrayDeque<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    levelDeque.addLast(node.val);
                } else {
                    levelDeque.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(new ArrayList<>(levelDeque));
            leftToRight = !leftToRight;
        }

        return result;
    }
}
