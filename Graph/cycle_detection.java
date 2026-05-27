import java.util.ArrayList;

public class cycle_detection {
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

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));
        graph[2].add(new edge(2, 4));

        graph[3].add(new edge(3, 0));

        graph[4].add(new edge(4, 2));
    }

    public static boolean Detect_cycle_by_dfs(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycle_helper(graph, i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycle_helper(ArrayList<edge> graph[], int curr, boolean vis[], int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (cycle_helper(graph, e.dest, vis, curr)) {
                    return true;
                }
            }
            // case 1
            else if (e.dest != par) {
                return true;
            }
            // case 2 nothing just continue
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        System.out.println(Detect_cycle_by_dfs(graph));
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");

            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest + " ");
            }

            System.out.println();
        }

    }
}
