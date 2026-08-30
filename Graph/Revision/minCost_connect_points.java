//Approach 
//in this used prim's algorithm
//as we study In prims we have to check for isMst contain vertex for next minCost so ,
//in this we used priorty queue for get minCost vertices
//after adding all possible Cost to pq 
// then further we calculate mincost when new currInfo we get also with that We include that vertices to isMst set 

class Solution {

    public int minCostConnectPoints(int[][] points) {
        boolean vis[] = new boolean[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        int minCost =0;
        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            if(!vis[curr[0]]){
                vis[curr[0]] = true;
                minCost += curr[1];
                for(int i =0;i<points.length;i++){
                    if(!vis[i]){
                        int wt = Math.abs(points[curr[0]][0]-points[i][0])+Math.abs(points[curr[0]][1]-points[i][1]);
                        pq.add(new int[]{i,wt});
                    }
                }
            }
        }
        return minCost;
    }
}
