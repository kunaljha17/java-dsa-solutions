//Approach 
//in this i use BFS Topo sort , because there i think that atleast one course is definetly they do not require any prereqs.. 
//so , i do indegree approach find 0 indegree node then add to queue after this i make while loop then take that node from queue with that i incr num so atlast i verify that all course is checked or not 
//then , all related to curr i decrease there indegree and check if after decrease does equal to 0 then add to queue
//indegree == indgree (`-`)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indgree[] = new int[numCourses];

        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
             graph[i] = new ArrayList<>();
            }
            
        for(int i = 0;i<prerequisites.length;i++){
            int a = prerequisites[i][0],b = prerequisites[i][1];//(a,b) so b->a
            graph[b].add(a);
            indgree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indgree[i]==0){
                q.add(i);
            }
        }
         int num =0;
        while(!q.isEmpty()){
            int curr = q.remove();
            num++;
            for(int i =0;i<graph[curr].size();i++){
                int u = graph[curr].get(i);
                if(--indgree[u]==0) q.add(u);            
            }
        }
        return num==numCourses;
    }
}
