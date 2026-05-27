import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class connected_component {

    static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void dfs(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    //<<<<<<<<<-----BFS-------->>>>>>>>>>>
        public static void Bfs(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                BfsUtil(graph , vis , i);
            }
        }
    }
    public static void BfsUtil(ArrayList<edge> graph[], boolean vis[] ,int start){  //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print( curr + " ");
            for(int i =0 ;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
        
    }


    
    public static void main(String[] args) {

    }
}
