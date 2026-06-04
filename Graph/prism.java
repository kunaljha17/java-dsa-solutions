import java.util.ArrayList;
import java.util.PriorityQueue;

public class prism {

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

    static class pair implements Comparable<pair> {
        int v;
        int cost;

        public pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void prismAlgo(ArrayList<edge> graph[]) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        int totalCost = 0;
        pq.add(new pair(0, 0));
        while (!pq.isEmpty()) {
            pair currPair = pq.remove();
            if (!vis[currPair.v]) {
                totalCost += currPair.cost;
                vis[currPair.v] = true;
                for (int i = 0; i < graph[currPair.v].size(); i++) {
                    edge e = graph[currPair.v].get(i);
                    pq.add(new pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Total cost is : "+totalCost);
    }

    public static void main(String[] args) {

    }

}