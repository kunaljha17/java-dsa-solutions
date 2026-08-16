//Approach : here we use priorityqueue in this prblm .. one of finest problem this is 
//first use priority Queue for piking smallest obj (val,ListIdx,EleIdx) comparing val for smallest obj.
//then make one max variable to store maximum of one column of list
//first store first column (val,ListIdx,eleIdx) into heap ,then make one ans 1D array with size 2
//make loop true until heap size equal to number of list means k.
//until check and add again new obj





class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            heap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        int[] ans = new int[]{0, Integer.MAX_VALUE};
        while (heap.size() == nums.size()) {  
            int[] top = heap.poll();
            int min = top[0], listIdx = top[1], elemIdx = top[2];
            if (max - min < ans[1] - ans[0]) {
                ans[0] = min;
                ans[1] = max;
            }
            if (elemIdx + 1 == nums.get(listIdx).size()) break; 
            int nextVal = nums.get(listIdx).get(elemIdx + 1);
            heap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
            max = Math.max(max, nextVal);
        }
        return ans;
    }
}
