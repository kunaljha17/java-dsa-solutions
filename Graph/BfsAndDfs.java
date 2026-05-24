import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfs {

    static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<edge> graph[], int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 3));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 4));

        graph[3].add(new edge(3, 4));
        graph[3].add(new edge(3, 1));
        graph[3].add(new edge(3, 5));

        graph[4].add(new edge(4, 5));
        graph[4].add(new edge(4, 2));
        graph[4].add(new edge(4, 3));

        graph[5].add(new edge(5, 3));
        graph[5].add(new edge(5, 4));
        graph[5].add(new edge(5, 6));

        graph[6].add(new edge(6, 5));
    }

    ////////// <<<<<<<<<<Another improved bfs >>>>>>>>>

    // public static void bfs_traverse(ArrayList<edge> graph[]) {
    // Queue<Integer> q = new LinkedList<>();
    // boolean vis[] = new boolean[graph.length];

    // q.add(0);
    // vis[0] = true;

    // while (!q.isEmpty()) {
    // int curr = q.remove();

    // System.out.print(curr + " ");

    // for (int i = 0; i < graph[curr].size(); i++) {
    // edge e = graph[curr].get(i);

    // if (!vis[e.dest]) {
    // q.add(e.dest);
    // vis[e.dest] = true;
    // }
    // }
    // }
    // }

    public static void bfs_traverse(ArrayList<edge> graph[]) {//M-1
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs_traverse(ArrayList<edge> graph[], int curr, boolean vis[]) {
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs_traverse(graph, e.dest, vis);
            }
        }

    }

    public static boolean has_path(ArrayList<edge> graph[], int src, int dest, boolean vis[]) {

        if (src == dest) {
            return true;
        }
        // visit
        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            edge e = graph[src].get(i);
            if (!vis[e.dest] && has_path(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;   
    }


    public static void main(String[] args) {
        int v = 7;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph, v);
        boolean vis[] = new boolean[graph.length];
        // bfs_traverse(graph);
        dfs_traverse(graph, 0, vis);

    }
}
