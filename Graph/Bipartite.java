//Approaches there is two approaches i currently know 
// approach 1 :  Recursive Depth-First Search (DFS) — often cleaner and uses less boilerplate than BFS.
// approach 2 : Disjoint Set Union (DSU / Union-Find) — groups neighbors into the same partition without explicit color arrays.

// here is appraoch 1code 

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int c, int[] color, int[][] graph) {
        color[node] = c;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(neighbor, -c, color, graph)) {
                    return false;
                }
            } else if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }
}



// -----------------------------


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

        static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // O(V+E)
    public static boolean isBipartite(ArrayList<edge> graph[]){
        int col[] = new int[graph.length];
        for(int i = 0 ; i <graph.length;i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<graph.length;i++){
            if (col[i] == -1) {
                q.add(i);
                col[i]=0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j =0;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0?1:0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false; //NOT Bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
