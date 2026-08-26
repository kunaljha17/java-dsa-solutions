//This problem i solve on gfg .
//previouly i try directly but i understand issue of out of bound , bcz i do vis check with edge cal  here issue

// but  in this i convert it to my desire graph then do

class Solution {
    
    public void dfs(ArrayList<Integer> graph[],boolean[] vis,Stack<Integer> s ,int curr){
        vis[curr] = true;
        for(int e:graph[curr]){
            if(!vis[e]){
                dfs(graph,vis,s,e);
            }
        }
        s.push(curr);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<Integer> graph[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0] ,v = edges[i][1];
            graph[u].add(v);
        }
        
         boolean[] vis = new boolean[V];
         ArrayList<Integer> ans = new ArrayList<>();
         Stack<Integer> s = new Stack<>();
         
         for(int i =0;i<V;i++){
             if(!vis[i]){
                 dfs(graph,vis,s,i);
             }
         }
         while(!s.isEmpty()){
             ans.add(s.pop());
         }
        return ans;
    }
}
