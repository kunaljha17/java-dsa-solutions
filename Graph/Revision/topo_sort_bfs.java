//Same approach as course scheduling 
//normal topo_sort with bfs
//using indegree


class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
         int indgree[] = new int[V];
         Stack<Integer> s = new Stack<>();
         ArrayList<Integer> ans = new ArrayList<>();
         ArrayList<Integer> graph[] = new ArrayList[V];
         for (int i = 0; i < V; i++) {
              graph[i] = new ArrayList<>();
             }

         for(int i = 0;i<edges.length;i++){
             int a = edges[i][0],b = edges[i][1]; 
             graph[b].add(a);
             indgree[a]++;
         }
         Queue<Integer> q = new LinkedList<>();
         for(int i =0;i<V;i++){
             if(indgree[i]==0){
                 q.add(i);
             }
         }
          int num =0;
         while(!q.isEmpty()){
             int curr = q.remove();
             s.push(curr);
             num++;
             for(int i =0;i<graph[curr].size();i++){
                 int u = graph[curr].get(i);
                 if(--indgree[u]==0) q.add(u);            
             }
         }
         while(!s.isEmpty()){
             ans.add(s.pop());
         }
         return ans;
        
    }
}
