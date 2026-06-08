import java.util.ArrayList;
import java.util.Collections;

public class kruskal {
    static class edge implements Comparable<edge> {
        int src, dest, wt;

        public edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(edge e2) {
            return this.wt - e2.wt;
        }
    }
    static void createGraph(ArrayList<edge> edges){
        edges.add(new edge(0, 1, 10));
        edges.add(new edge(0, 2, 15));
        edges.add(new edge(0, 3, 30));
        edges.add(new edge(1, 3, 40));
        edges.add(new edge(2, 3, 50));
    }
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i =0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }

    public static int find(int x){
        if (x==par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if (parA==parB) {
            return;
        }
        if (rank[parA]==rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }

    public static void kruskall(ArrayList<edge> edges, int V){
        Collections.sort(edges);
        int MstCost = 0;
        int count = 0;
        
        for(int i =0;count<V-1;i++){
            edge e = edges.get(i);
            // (src,dest,wt)

            int parA = find(e.src); //src =a
            int parB = find(e.dest);// dest =b
            if (parA != parB) {
                union(e.src, e.dest);
                MstCost +=e.wt;
                count++;
            }

        }
        System.out.println("MST COST : "+MstCost);
    }



    public static void main(String[] args) {
        int V=4;

        init();
        ArrayList<edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskall(edges, V);

    }
}