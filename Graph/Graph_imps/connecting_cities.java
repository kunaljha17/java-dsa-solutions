package Graph_imps;

import java.util.PriorityQueue;

public class connecting_cities {

    static class edge implements Comparable<edge> { 
        int dest;
        int cost;

        public edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int Cities_min_cost(int cities[][]) {
        PriorityQueue<edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        int totalCost = 0;
        pq.add(new edge(0, 0));

        while (!pq.isEmpty()) {
            edge e = pq.remove();
            if (!vis[e.dest]) {
                vis[e.dest] = true;
                totalCost += e.cost;

                for (int i = 0; i < cities[e.dest].length; i++) {
                    if (cities[e.dest][i] != 0) {
                        pq.add(new edge(i, cities[e.dest][i]));
                    }
                }
            }

        }
        return totalCost;
    }

    public static void main(String[] args) {

    }
}
