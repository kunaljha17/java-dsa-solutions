// Use two pointers: leader (a node on the current level, start with root) and a dummy node to build the next level's chain.
// Traverse the current level using leader.next, and for each leader, link its children (leader.left.next = leader.right, and leader.right.next = leader.next.left if leader.next exists).
// Move leader to leader.next; once you exhaust the level, move down to the next level's start (via the dummy).





class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next; 
            }
            leftmost = leftmost.left;  
        }
        return root;
    }
}
