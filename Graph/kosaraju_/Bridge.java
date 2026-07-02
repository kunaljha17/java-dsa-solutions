import java.util.ArrayList;

public class Bridge {
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

    public static void BridgeHelper(ArrayList<edge> graph[], int curr , boolean vis[] , int dt[],int low[],int time,int par){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for(int i =0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }
            if (!vis[e.dest]) {
                BridgeHelper(graph, e.dest, vis, dt, low, time, e.src);
                low[e.src] = Math.min(low[e.src], low[e.dest]);
                if (dt[e.src]<low[e.dest]) {
                    System.out.println("Bridge found : "+ e.src + " --- " +e.dest);
                }  
            }
            else{
                low[e.src] = Math.min(low[e.src], dt[e.dest]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<edge> graph[], int v){
        boolean vis[] = new boolean[v];
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        for(int i =0;i<v;i++){
            if (!vis[i]) {
                BridgeHelper(graph, i, vis,dt,low,time , -1);
            }
        }
    }

    public static void main(String[] args) {
        int v =6;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        tarjanBridge(graph, v);
    }
}
