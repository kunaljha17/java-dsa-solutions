import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_part1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree {
        static int idx = -1;

        public Node BuildTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = BuildTree(Nodes);
            newNode.right = BuildTree(Nodes);
            return newNode;
        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void LevelOrderTransversal(Node root) {
            Queue<Node> q = new LinkedList<>();
            if (root == null) {
                return;
            }
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode==null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                 }else{
                    System.out.print(currNode.data+" ");
                    if (currNode.left!=null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right!=null) {
                        q.add(currNode.right);
                    }
                 }
            }
        }

        public int TreeHeight(Node root){

            if (root==null) {
                return 0;
            }
            int left = TreeHeight(root.left);
            int Right = TreeHeight(root.right);
            return Math.max(left,Right) +1;
        }

        public int CountNode(Node root){
            if (root == null) {
                return 0;
            }
            int left = CountNode(root.left);
            int right = CountNode(root.right);
            return left +right +1;
        }
        public int SumOfNodes(Node root){
            if (root == null) {
                return 0;
            }
            int left = CountNode(root.left);
            int right = CountNode(root.right);
            return left +right +root.data;
        }

    }

    public static void main(String[] args) {
        Binarytree t = new Binarytree();
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = t.BuildTree(arr);
        // System.out.println(root.data);
        // t.inOrder(root);
        System.out.println(t.CountNode(root));
    }
}
