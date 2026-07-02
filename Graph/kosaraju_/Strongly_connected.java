import java.util.*;

public class Strongly_connected {

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
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));
        graph[1].add(new edge(1, 0));
        graph[2].add(new edge(2, 1));
        graph[3].add(new edge(3, 4));
    }

    public static void topoSort(ArrayList<edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void StackDfs(ArrayList<edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                StackDfs(graph, e.dest, vis);
            }
        }
    }

    public static void KosarajuAlgo(ArrayList<edge> graph[], int v) { // O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];

        // step 1
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topoSort(graph, i, vis, s);
            }
        }

        // step -2
        ArrayList<edge> TransposeGraph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            TransposeGraph[i] = new ArrayList<>();
            vis[i] = false;
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                edge e = graph[i].get(j);
                int src = e.src;
                int dest = e.dest;
                TransposeGraph[dest].add(new edge(dest, src));
            }
        }

        // step - 3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC -> ");
                StackDfs(TransposeGraph, curr, vis);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<edge> graph[] = new ArrayList[v];

        create_graph(graph);

        KosarajuAlgo(graph, v);
    }
}