import java.util.ArrayList;

public class BellmanFord {

    static class edge {
        int src;
        int dest;
        int wt;

        edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void create_graph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 7));
        graph[2].add(new edge(2, 4, 3));
        graph[3].add(new edge(3, 5, 1));
        graph[4].add(new edge(4, 3, 2));
        graph[4].add(new edge(4, 5, 5));
    }


// Outer loop → V-1 times
// Middle loop → all vertices
// Inner loop → all edges
    public static void BellmanAlo(ArrayList<edge> graph[], int src) { // O(V*E)
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;   //[0, ∞, ∞, ∞, ∞, ∞]
            }
        }

        int v = graph.length;
        for (int i = 0; i < v - 1; i++) {

            for (int j = 0; j < v; j++) {

                for (int k = 0; k < graph[j].size(); k++) {
                    edge e = graph[j].get(k);
                    int u = e.src;
                    int uNext = e.dest; //
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[uNext]) {
                        dist[uNext] = dist[u]+wt;
                    }
                }
            }
        }

        for(int i =0 ; i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V= 5;
        ArrayList<edge> graph[] = new ArrayList[V];
        create_graph(graph);    
        BellmanAlo(graph, 0);
    }
}
