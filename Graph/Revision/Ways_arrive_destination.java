//This is very important problem 
//Here use Dijkstra + number of shortest paths both together
// we have actually find number of shortest paths from 0 to n-1 vertice
//new distance < old distance
//         ↓
// replace shortest distance
// ways[v] = ways[u] //here update ways

//One important note that here in this problem we have to use long so distane avoid overflow  issue

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<int[]> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            graph[u].add(new int[]{v,wt});
            graph[v].add(new int[]{u,wt});
        }
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] =1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.offer(new long[]{0,0});
        while(!q.isEmpty()){
            long[] curr = q.poll();
            int u = (int)curr[0];
            long wt = curr[1];

            if(wt>dist[u]) continue;

            for(int []neigh : graph[u]){
                int v = neigh[0];
                long time = neigh[1];
                if(time+dist[u]<dist[v]){//Found a shorter path
                    dist[v] = time+dist[u];
                    ways[v] = ways[u];
                    q.offer(new long[]{v ,dist[v]});
                }
                else if(time+dist[u]==dist[v]){ // Found another shortest path
                    ways[v] = (ways[u]+ways[v])%1000000007;
                }
            }
        }
        return ways[n-1];

    }
}
