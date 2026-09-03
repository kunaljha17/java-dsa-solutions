//Approach

// this is simple problem like connect graph problem in this we only count of connected graph
//First i do this 😅 i didn't notice that that this is adj matrix problem 
// but we also do without making adj list graph , do direct adj matrix problem



class Solution {

    public void dfs(ArrayList<Integer> graph[],boolean[] vis,int curr){
        vis[curr] = true;
        for(int e :graph[curr]){
             if(!vis[e]) dfs(graph,vis,e);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i =0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int numProvince = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                numProvince++;
                dfs(graph,vis,i);
            }
        }
        return numProvince;
    }
}



//Approch 2 without making adj list 

class Solution {

    public void dfs(int[][] graph, boolean[] vis, int curr) {
        vis[curr] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[curr][i] == 1 && !vis[i]) {
                dfs(graph, vis, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int numProvince = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                numProvince++;
                dfs(isConnected, vis, i);
            }
        }

        return numProvince;
    }
}
