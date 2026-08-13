class Solution {

    Node successor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public int inOrderSuccessor(Node root, Node k) {
        Node curr = root;
        Node succ = null; 
        while (curr != null) {
            if (curr.data > k.data) {
                succ = curr;          // curr could be the successor
                curr = curr.left;     // look smaller
            } else if (curr.data < k.data) {
                curr = curr.right;
            } else {
                // found k ...
                if (curr.right != null) {
                    succ = successor(curr.right);
                }
                break;
            }
        }
        return succ == null ? -1 : succ.data;
    }
}
