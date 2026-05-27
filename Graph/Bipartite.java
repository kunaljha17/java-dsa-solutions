import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

        static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // O(V+E)
    public static boolean isBipartite(ArrayList<edge> graph[]){
        int col[] = new int[graph.length];
        for(int i = 0 ; i <graph.length;i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<graph.length;i++){
            if (col[i] == -1) {
                q.add(i);
                col[i]=0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j =0;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0?1:0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false; //NOT Bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
