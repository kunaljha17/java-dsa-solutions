import java.util.*;

public class levelOrder {

    public void levelO(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }else{
                    break;
                }
            }else{
                System.out.print(currNode.data +" ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
}
