public class height {
   public static int heightNode(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(heightNode(root.left), heightNode(root.right)) +1;
   }
}
