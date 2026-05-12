public class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static class buildtree {
        static int idx = -1;

        public Node tree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = tree(nodes);
            newNode.right = tree(nodes);
            return newNode;
        }

    }

    public static void main(String[] args) {
        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        buildtree t = new buildtree();
        levelOrder l = new levelOrder();
        Node root = t.tree(nodes);
        // l.levelO(root);
        height he = new height();
        CountNode Cn = new CountNode();
        
    //   System.out.println(he.heightNode(root));
        // System.out.println(Cn.countN(root));
        topView tp = new topView();
        tp.top_view_tree(root);
    }
}
