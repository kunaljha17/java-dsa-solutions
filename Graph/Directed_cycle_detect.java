import java.util.ArrayList;

public class Directed_cycle_detect {

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
        graph[1].add(new edge(1, 3));
        graph[2].add(new edge(2, 3));
    }

    public static boolean isCycleDetect(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i =0 ;i<graph.length;i++){
            if (!vis[i]) {
                if (isCycleUtil(graph , i , vis , stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<edge> graph [], int curr , boolean vis[],boolean stack []){
        vis[curr] = true;
        stack[curr] = true;
        for(int i =0 ; i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest]) {
                if ( isCycleUtil(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }


    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        System.out.println(isCycleDetect(graph));

        
    }
}
