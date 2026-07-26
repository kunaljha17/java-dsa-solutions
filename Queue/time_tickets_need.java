// Optimal approach 

// Stop when person k buys their last ticket.
// Count each person's contribution instead of simulating the queue.
// Let target = tickets[k].
// If i <= k, person i gets the final round.
// Contribution = min(tickets[i], target).
// If i > k, person i misses the final round.
// Contribution = min(tickets[i], target - 1).
// Sum all contributions.
// Return the total time.
// Formula: i <= k ? min(tickets[i], target) : min(tickets[i], target - 1).
// Time Complexity: O(n).
// Space Complexity: O(1).

// Memory Trick: Before/At k → gets last turn; After k → misses last turn.


//approach 2
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
         Queue<int[]> q = new LinkedList<>();
        int size = tickets.length;
         
         for(int i =0;i<size;i++){
            q.add(new int[]{tickets[i],i});
         }
        int totalTime = 0;
        
        while( !q.isEmpty()){
            int[] curr = q.remove();
                curr[0]--;
                totalTime++;
                if(curr[0]==0 && curr[1]==k) return totalTime;
                if(curr[0]>0) q.add(curr);
        }
        return totalTime;
    }
}
