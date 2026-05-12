import java.util.ArrayList;

public class BinaryTreeP3 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//Q1
    public static void kThLevel(Node root, int level, int k) {

        if (root == null) {
            return;
        }

        if (k == level) {
            System.out.print(root.data + " ");
            return;
        }
        kThLevel(root.left, level + 1, k);
        kThLevel(root.right, level + 1, k);
    }
//
//Q2
    public static boolean getpath(Node root, ArrayList<Node> path, int n) {

        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean leftpath = getpath(root.left, path, n);
        boolean rightpath = getpath(root.right, path, n);

        if (leftpath || rightpath) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, path1, n1);
        getpath(root, path2, n2);

        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }
        System.out.print("Lowest common ancestor is : " + path1.get(i - 1).data);
    }
//
//Q2->A(2)
    public static Node lac2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {// root == null is base case and comparing n1 and n2 is
                                                                 // main case So, i merge both into single
            return root;
        }

        Node leftNode = lac2(root.left, n1, n2);
        Node RightNode = lac2(root.right, n1, n2);

        if (leftNode == null) {// leftNode is null then rightNode has value
            return RightNode;
        }
        if (RightNode == null) {// RightNode is null then leftNode has value
            return leftNode;
        }

        return root;// this is case when both had a value in . left and right (Node)
    }

    //Q3
    public static int DistanceFromLCA(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftValue = DistanceFromLCA(root.left, n);
        int rightValue = DistanceFromLCA(root.right, n);

        if (leftValue == -1 && rightValue == -1) {
            return -1;
        } else if (leftValue == -1) {
            return rightValue + 1;
        } else {
            return leftValue + 1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lcadist = lac2(root, n1, n2);
        int n1Dist = DistanceFromLCA(lcadist, n1);
        int n2Dist = DistanceFromLCA(lcadist, n2);

        return n1Dist + n2Dist;
    }

    //Q4
    public static int kthAnsestor(Node root, int k, int value) {
        if (root == null) {
            return -1;
        }
        if (root.data == value) {
            return 0;
        }
        int leftValue = kthAnsestor(root.left, k, value);
        int rightValue = kthAnsestor(root.right, k, value);

        if (leftValue == -1 && rightValue == -1) {
            return -1;
        }

        int max = Math.max(leftValue, rightValue);
        if (max == k) {
            System.out.print(root.data);
        }
        return max + 1;
    }

    //Q5
    public static int TransformTree(Node root){
        if (root == null ) {
            return 0;
        }
        int leftChildSubtree = TransformTree(root.left);
        int RightChildSubtree = TransformTree(root.right);

        int newleft= root.left ==null?0:root.left.data;
        int newright = root.right ==null?0:root.right.data;

        int val = root.data;
        root.data = leftChildSubtree + newleft + RightChildSubtree + newright;
        return val;
    }

    public static void preorder(Node root){
        if (root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
     

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        // kThLevel(root, 1, 2);
        preorder(root);
        System.out.println();
        TransformTree(root);
        preorder(root);


    }
}
