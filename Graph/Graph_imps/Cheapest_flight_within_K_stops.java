package Graph_imps;

import java.util.*;

public class Cheapest_flight_within_K_stops {

    static class edge {
        int src;
        int dest;
        int wt;

        public edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void create_graph(int flights[][], ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[i].add(new edge(src, dest, wt));
        }
    }

    static class info{
        int v;
        int cost;
        int stops;

        public info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
 
    }

    public static int CheapestFlight(int n, int flights[][],int src, int dest, int k){
    ArrayList<edge> graph[] = new ArrayList[n];
    create_graph(flights, graph);
    int dist[] = new int[graph.length];

           for(int i =0;i<n;i++){
            if (i !=src) {
                dist[i] = Integer.MAX_VALUE;
            }
           }

        Queue<info> q = new LinkedList<>();
        q.add(new info(src, 0, 0));

        while (!q.isEmpty()) {
            info currInfo = q.remove();
            if (currInfo.stops > k) {
                break;
            }

            for(int i =0;i<graph[currInfo.v].size();i++){
                edge e = graph[currInfo.v].get(i);
                int V = e.dest;
                int wt = e.wt;

                if (currInfo.cost + wt <dist[V] && currInfo.stops<=k) {
                    dist[V] = currInfo.cost + wt;
                    q.add(new info(V, dist[V],currInfo.stops+1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }
        else{
            return dist[dest];
        }
    }

    public static void main(String[] args) {

    }

}