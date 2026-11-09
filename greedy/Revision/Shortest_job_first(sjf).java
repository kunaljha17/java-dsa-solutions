class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int wt = 0;
        int t = 0;
        
        for(int i =0;i<bt.length-1;i++){
            wt +=bt[i];
            t +=wt;
        }
        return t/bt.length;
        
        
    }
}
