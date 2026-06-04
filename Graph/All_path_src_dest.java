import java.util.ArrayList;

public class All_path_src_dest {
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

        graph[0].add(new edge(0, 3));
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 1));
        graph[4].add(new edge(4, 0));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
    }

   

    public static void AllPath(ArrayList<edge> graph[], int src , int dest , String path){

        if (src==dest) {
           System.out.println(path+dest);
           return;
        }
        for(int i = 0 ;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            AllPath(graph, e.dest, dest, path+src);
        }

    }

     
    public static void main(String[] args) {
        ArrayList<edge> graph[] =  new ArrayList[6];
        create_graph(graph);
        AllPath(graph, 5, 1, new String(""));
     }
}
