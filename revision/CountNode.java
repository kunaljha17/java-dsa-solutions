public class CountNode {
     
    public int countN(Node root){
        if(root == null){
            return 0;
        }

       int ls = countN(root.left);
       int Rs = countN(root.right);
        return ls + Rs +1; 
    }
}
