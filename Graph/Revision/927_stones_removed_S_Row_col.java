//Approch : this is very classic problem , 
//in this use graph like bfs traversal 
//in this sequence we have to first check does this index row and col visited or not , then if not visited then add 
//that index to queue and then until empty run loop inside like.
//first pik row and col by index , then run loop for that index that is currently not remvoed or visited 
//then found index not visited ,(actually visited use as removed index or coordinate element stones),then match Row and Col if match then remove that index and put that index to queue
//for further check for removing
//Also import that in starting i do RemoveCount++ means chain count



class Solution {
 
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int RemoveCount = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                RemoveCount++;
                vis[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int currIdx = q.remove();
                    int Row = stones[currIdx][0];
                    int Col = stones[currIdx][1];
                    for(int nextIdx =0;nextIdx<n;nextIdx++){
                        if(!vis[nextIdx]){
                            if(Row == stones[nextIdx][0] || Col == stones[nextIdx][1]){
                                vis[nextIdx] = true;
                                q.offer(nextIdx);
                            }
                        }
                    }
                }
            }
        }
        return n - RemoveCount;
    }
}
