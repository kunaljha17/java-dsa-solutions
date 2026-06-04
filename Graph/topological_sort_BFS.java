import java.util.*;

public class topological_sort_BFS {
        static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void create_graph(ArrayList<edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 1));
        graph[4].add(new edge(4, 0));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
         
    }

    public static void CalInDegree(ArrayList<edge> graph[], int indegree[]){
        
        for(int i =0;i<graph.length;i++){//for each vertices
            for(int j =0;j<graph[i].size();j++){//for picking each edge
                edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topoSort(ArrayList<edge> graph[]){
        int indegree[] = new int[graph.length];
        CalInDegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<indegree.length;i++){
            if (indegree[i]==0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i = 0;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest]==0) {
                    q.add(e.dest);
                }
            }
            
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        topoSort(graph);
          
    }

    
}
