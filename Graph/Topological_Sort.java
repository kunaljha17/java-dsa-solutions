import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort {

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

    public static void topo_sort(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i<graph.length;i++){
            if (!vis[i]) {
                topo_Sort_util(graph,i,vis,stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void topo_Sort_util(ArrayList<edge> graph[], int curr , boolean vis[], Stack<Integer> stack){
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topo_Sort_util(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        
    }
}
