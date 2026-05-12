import java.util.*;

public class BuildBST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public Node insert(Node root, int values) {

        if (root == null) {
            return new Node(values);
        }
        if (root.data > values) {
            insert(root.left, values);
        } else {
            insert(root.right, values);
        }
        return root;
    }

    public boolean SearchNode(Node root, int key) {//O(H) H for height
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return SearchNode(root.left, key);
        } else {
            return SearchNode(root.right, key);
        }
    }



    // <<<<<<<<<<<<<<<<--------->>>>>>>>>>>>>
// Function to find the Inorder Successor of a node
// Inorder successor = smallest value node in the right subtree
public Node findInorderSuccessor(Node root) {

    // Keep moving to the leftmost node
    // because in BST, leftmost node has the minimum value
    while (root.left != null) {
        root = root.left;
    }

    // Return the smallest node found
    return root;
}


// Function to delete a node from Binary Search Tree (BST)
public Node DeleteNode(Node root, int val) {   // Good question – important BST concept

    // If value to be deleted is greater than root value,
    // move to the right subtree
    if (root.data < val) {
        root.right = DeleteNode(root.right, val);
    }

    // If value to be deleted is smaller than root value,
    // move to the left subtree
    else if (root.data > val) {
        root.left = DeleteNode(root.left, val);
    }

    // If current node value matches the value to be deleted
    else {

        // Case 1: Leaf Node (no children)
        // Simply delete the node by returning null
        if (root.left == null && root.right == null) {
            return null;
        }

        // Case 2: Node with only right child
        // Replace node with its right child
        if (root.left == null) {
            return root.right;
        }

        // Case 2: Node with only left child
        // Replace node with its left child
        else if (root.right == null) {
            return root.left;
        }

        // Case 3: Node with two children
        // Find inorder successor (smallest in right subtree)
        Node IS = findInorderSuccessor(root.right);

        // Replace current node data with inorder successor data
        root.data = IS.data;

        // Delete the inorder successor node from right subtree
        root.right = DeleteNode(root.right, IS.data);
    }

    // Return updated root after deletion
    return root;
}
//<<<<<<<<<<<----------->>>>>>>>>>.

    public void printRange(Node root , int k1, int k2){
        if (root ==null) {
            return;
        }
        if (root.data>=k1&&root.data<=k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printRange(root.right, k1, k2);
        }
        else{
            printRange(root.left, k1, k2);
        }
    }
    
     

    public void printpath(ArrayList<Node> list){
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i).data+" ");
        }
    }

    public void RoottoleafPath(Node root ,ArrayList<Node> list){
        if (root  ==null) {
            return;
        }
         
        list.add(root);
        if (root.left==null&&root.right==null) {
            printpath(list);
        }
        RoottoleafPath(root.left ,list);
        RoottoleafPath(root.right, list);
        list.remove(list.size()-1);
    }

    

    public boolean isValidBst(Node root,Node min ,Node max){
        if (root==null) {
            return true;
        }
        
        if (min!=null&&root.data<=min.data) {
            return false;
        }
        if (max!=null&&root.data>=max.data) {
            return false;
        }
        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }



    

    public Node MirrorBST(Node root ){
        if (root==null) {
            return null;
        }
       Node left = MirrorBST(root.left);
        Node right = MirrorBST(root.right);
        
        root.left = right;
        root.right = left;
        return root;
    }
    public void preOrder(Node root){
        if (root==null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        BuildBST bst = new BuildBST();
        Node root = null;
        int vals[] = { 5, 1, 3, 4, 2, 7 };
        for (int i = 0; i < vals.length; i++) {
            bst.insert(root, vals[i]);
        }
        bst.printRange(root, 1, 5);
    }
}
