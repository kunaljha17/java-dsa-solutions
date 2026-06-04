import java.util.*;

public class Dijsktra {

    static class edge {
        int src; 
        int dest;
        int wt;
        edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    public static void create_graph(ArrayList<edge> graph[]){
        for(int i = 0;i<graph.length;i++){
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

    static class info implements Comparable<info>{
        int v;
        int wt;
        public info(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        @Override
        public int compareTo(info i2){
            return this.wt - i2.wt;
        }
    }

    public static void dijsktraAlo(ArrayList<edge> graph[],int src , int dest){ //O(V+ElogV)
        int dist [] = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
             if (i != src) {
                dist[i] = Integer.MAX_VALUE;
             }
        }
        PriorityQueue<info> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        pq.add(new info(src, 0));
         
        while (!pq.isEmpty()) {
            info curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] =true;

                for(int i = 0;i<graph[curr.v].size();i++){
                    edge e = graph[curr.v].get(i);
                    int wt = e.wt;
                    if (dist[e.src]+ wt<dist[e.dest]) {
                        dist[e.dest] = dist[e.src] +wt;
                        pq.add(new info(e.dest, dist[e.dest]));
                    }
                }
            }
        }
        for(int i =0;i<graph.length;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        // ArrayList<edge> graph[] = new ArrayList[6];
        
    }
}
