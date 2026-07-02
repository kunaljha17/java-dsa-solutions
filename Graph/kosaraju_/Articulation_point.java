import java.util.ArrayList;

public class Articulation_point {

    static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void create_graph(ArrayList<edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));
        graph[1].add(new edge(1, 2));
        graph[1].add(new edge(1, 0));
        graph[2].add(new edge(2, 1));
        graph[2].add(new edge(2, 0));
        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));
        graph[3].add(new edge(3, 5));
        graph[4].add(new edge(4, 5));
        graph[4].add(new edge(4, 3));
        graph[5].add(new edge(5, 3));
        graph[5].add(new edge(5, 4));
    }

    public static void Dfs_articulation(ArrayList<edge> graph[], int curr, boolean vis[], int dt[], int low[], int par,
            int time , boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (vis[e.dest]) {
                low[e.src] = Math.min(low[e.src], dt[e.dest]); // e.src == curr
            } else {
                Dfs_articulation(graph, e.dest, vis, dt, low, e.src, time ,ap);
                low[e.src] = Math.min(low[e.src], low[e.dest]);
                if (par != -1 && dt[e.src] <= low[e.dest]) {
                     ap[e.src] = true;
                }
                children++;
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true; // e.src == curr
        }
    }

    public static void Articulation_point_tarjan(ArrayList<edge> graph[], int v) {
        boolean vis[] = new boolean[v];
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean ap [] = new boolean[v];
        
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                Dfs_articulation(graph, i, vis, dt, low, -1, time , ap);
            }
        }

        //Print all AP
        for(int i = 0;i<v;i++){
            if (ap[i]) {
                System.out.println("Articulation point : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int v =6;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        Articulation_point_tarjan(graph, v);

    }

}
