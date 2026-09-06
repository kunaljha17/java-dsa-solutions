//Approch 1
// In this we use tarjan algorithm , 
// in tarjan we store ancestor child relation ship , like we have discovery time and lowest discovery time 
//in this we have case for critical connections 
//case 1: low[neigh] >dt[curr] beacuse by this we have get critical edge
//actual thinking is that when discovery time is less than lowest discovery time of there neigh edge then
//we notice this curr node is like bridge like to connect to node .
//lowest discovery time is a lowest discovery time with there comparing with neighbour until we get visited node again there we compare min with curr low and neigh dt time
// Graph one of the best questions








class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i =0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> conn :connections){
            int u = conn.get(0),v=conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        int []dt = new int[n];
        int []low = new int[n];
        Arrays.fill(dt,-1);
        List<List<Integer>> bridge = new ArrayList<>();
        dfs(graph,bridge,dt,low,0,0,-1);
        return bridge;

    }

    public void dfs(ArrayList<Integer> graph[],List<List<Integer>> bridge,int []dt,int []low,int time,int curr,int par){
        dt[curr] = low[curr] = ++time;
        for(int e : graph[curr]){
            if( e == par) continue;
            
            if(dt[e] == -1){
                dfs(graph,bridge,dt,low,time,e,curr);
                low[curr]=Math.min(low[curr],low[e]);
                if(low[e]>dt[curr]){
                    bridge.add(Arrays.asList(curr,e));
                }
            }else{
                low[curr] = Math.min(low[curr],dt[e]);
            }
        }
    }
}
