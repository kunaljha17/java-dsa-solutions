//Similar to top view ...see notes 


class Solution {
    public class info{
        int hd;
        Node node;
        info(int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
         Queue<info> q = new ArrayDeque<>();
         HashMap<Integer,Node> map = new HashMap<>();
         q.add(new info(0,root));
         ArrayList<Integer> ans = new ArrayList<>();
         int min = 0;
         int max = 0;
         
         while(!q.isEmpty()){
             info currInfo = q.remove();
             map.put(currInfo.hd,currInfo.node);
             
             if(currInfo.node.left !=null){
                 q.add(new info(currInfo.hd-1,currInfo.node.left));
                 min = Math.min(currInfo.hd-1,min);
             }
             if(currInfo.node.right != null){
                 q.add(new info(currInfo.hd+1,currInfo.node.right));
                 max =  Math.max(max,currInfo.hd+1);
             }
             
         }
         for(int i = min; i<=max;i++){
             ans.add(map.get(i).data);
         }
         return ans;
        
    }
}
