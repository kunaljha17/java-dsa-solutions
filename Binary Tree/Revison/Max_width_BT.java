// Think in terms of positions (indices) in a complete binary tree.
// Every node has a position.
// Missing nodes still have reserved positions.
// Process the tree level by level (BFS is the easiest).
// For each level:
// Record the position of the first node.
// Record the position of the last node.
// Width = lastPosition - firstPosition + 1.
// Update the maximum width.
// When adding children to the queue, compute their positions based on the parent's position.




class Solution {

    class info{
        long idx;
        TreeNode node;
        public info(long idx, TreeNode node ){
            this.idx = idx;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<info> q = new ArrayDeque<>();
        q.add( new info(0,root));
        long width = 0;
        long firstIdx=0,lastIdx=0;
        while(!q.isEmpty()){

             int size = q.size();
             for(int i = 0;i<size;i++){
                info currInfo = q.remove();
                 if(i == 0) firstIdx = currInfo.idx;
                 if(i==size-1) lastIdx = currInfo.idx;
                 if(currInfo.node.left != null){
                    q.add(new info((long)2*currInfo.idx+1,currInfo.node.left));
                 }
                 if(currInfo.node.right != null){
                    q.add(new info((long)2*currInfo.idx+2,currInfo.node.right));
                 }
             }
             width = Math.max(width,lastIdx-firstIdx+1);
        }
        return (int)width;
    }
}
