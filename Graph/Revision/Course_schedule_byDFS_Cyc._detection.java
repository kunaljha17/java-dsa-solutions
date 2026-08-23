//Approach 1 (This i used previously cycle detection dfs directed graph)
//In this used new technique of using state array , because
//vis[]     = "Have I met this person before?"
// Stack[] = "Is this person currently walking with me?"

//Why only not use vis array : in directed graph previously visited node is not necessarily a cycle.




//Approach 2

//here i use array state that do 3 thing together ,track unvis (0), current walk in dfs track (1),complete dfs previously(2)
// everything same as approach 1 just do this in approach 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1]; // b -> a
            graph[b].add(a);
        }

        int[] state = new int[numCourses]; // 0 = unvisited, 1 = in progress, 2 = done

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i)) return false;
            }
        }
        return true;
    }

    private boolean hasCycle(ArrayList<Integer>[] graph, int[] state, int curr) {
        state[curr] = 1; // mark as "in progress" (on current path)
        for (int next : graph[curr]) {
            if (state[next] == 1) return true;        // back edge -> cycle
            if (state[next] == 0 && hasCycle(graph, state, next)) return true;
        }
        state[curr] = 2; // done, safe
        return false;
    }
}
