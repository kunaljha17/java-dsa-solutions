//similar approach like topo sort by dfs but here i have check cycle too so  i have to use pathvis extra boolean array
//for walk touched node histoy save there
//and this was verry interestin and nice problem i beats 99% here




class Solution {

    public boolean  hasCycle(ArrayList<Integer>[] graph ,Stack<Integer> s,int curr,boolean[] vis,boolean[] pathvis){
        vis[curr] = true;
        pathvis[curr] = true;
        for(int e :graph[curr]){
            if(!vis[e]){
                if (hasCycle(graph, s, e, vis, pathvis)) {
                    return true;
                }
            }else if(pathvis[e]){
                return true;
            }
        }
        pathvis[curr] = false;
        s.push(curr);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
         
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1]; // b -> a
            graph[b].add(a);
        }
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        for(int i =0;i<numCourses;i++){
            if(!vis[i]){
                if(hasCycle(graph,s,i,vis,pathVis)){
                    return new int[0];
                }
            }
        }

        int ans[] = new int[numCourses];
        int i =0;
        while(!s.isEmpty()){
            ans[i] = s.pop();
            i++;
        }
        return ans;
    }

}
