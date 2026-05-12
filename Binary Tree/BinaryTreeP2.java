import java.util.*;

public class BinaryTreeP2 {

    static class Node {
        int data;
        Node left;
        Node Right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.Right = null;
        }

    }

    // static class InnerDiaTree { <<<<---->>>> Approach 1 O(N^2)

    // public int height(Node root) {
    // if (root == null) {
    // return 0;
    // }
    // int left = height(root.left);
    // int right = height(root.Right);
    // return Math.max(left, right) + 1;
    // }

    // public int dia(Node root) {//O(n^2)
    // if (root == null) {
    // return 0;
    // }
    // int leftDia = dia(root.left);
    // int lefth = height(root.left);
    // int rightDia = dia(root.Right);
    // int righth = height(root.Right);

    // int selfDia = lefth + righth + 1;
    // return Math.max(Math.max(leftDia, rightDia), selfDia );

    // }
    // }

    static class info {
        int ht;
        int dia;

        public info(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }

    public static info Diameter(Node root) {// O(n)
        if (root == null) {
            return new info(0, 0);
        }

        info leftInfo = Diameter(root.left);// get from return left node(dia,ht)
        info rightInfo = Diameter(root.Right);// get from return right node(dia,ht)

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new info(ht, dia);// return(dia , ht)
    }

    public static boolean isIdentical(Node root, Node subroot) {

        if (root == null && subroot == null) {// both node is null then . after leaf node case !
            return true;
        } else if (root.data != subroot.data || root == null || subroot == null) {// check when subtree is not
                                                                                  // identical. like one node is null
                                                                                  // only or not data matched
            return false;
        }
        if (!isIdentical(root.left, subroot.left)) {// check for subroot left with root left .
            return false;
        }
        if (!isIdentical(root.Right, subroot.Right)) {// similarly for right
            return false;
        }
        return true;// if subroot is found in root main tree then ..
    }

    public static boolean isSubTree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) { // send one node to isidentical for check subtree from there . because root
                                         // match so...
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        boolean leftAns = isSubTree(root.left, subroot);// first root is not match then send root left as root . check
                                                        // that node does this node match with subroot root data ...
                                                        // then proceed
        boolean RightAns = isSubTree(root.Right, subroot);// similarly for right as left not found

        return leftAns || RightAns;// return true if anyone left or right where subtree is found

    }

    static class TopviewOfBinaryTree {
        static class info2 {// info2 object class template
            Node node;
            int hd;

            public info2(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public void topview(Node root) {
            HashMap<Integer, Node> map = new HashMap<>();// hashmap initialization
            Queue<info2> q = new LinkedList<>();// in queue store info2 obj where node and horizontal distance is store
            int max = 0, min = 0;// for tracking min hd to max hd which help in printing hashmap as key
            // Level transversal we do here
            q.add(new info2(root, 0));// add root info2 obj in queue

            while (!q.isEmpty()) {// until queue is not empty
                info2 curr = q.remove();// store current info2 (node, hd)

                if (!map.containsKey(curr.hd)) {// first check that does hashmap contain this ..
                    map.put(curr.hd, curr.node);// if not then put in hashmap
                }
                if (curr.node.left != null) {// then check that in info2 in curr node left is not null
                    q.add(new info2(curr.node.left, curr.hd - 1));// because if not then make info2 for left and add in
                                                                  // queue
                    min = Math.min(min, curr.hd - 1);// minimum track where horizontal d. -1
                }
                if (curr.node.Right != null) { // similar for right node from curr node
                    q.add(new info2(curr.node.Right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
            for (int i = min; i <= max; i++) {// at the end here print all node data from hash map by using min and max
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // InnerDiaTree d = new InnerDiaTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.Right = new Node(5);
        root.Right = new Node(3);
        root.Right.Right = new Node(6);

        // System.out.println(Diameter(root).dia);
        TopviewOfBinaryTree tv = new TopviewOfBinaryTree();
        tv.topview(root);

    }
}
