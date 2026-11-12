//Here we have to return minimum number of jumps requiured to reach to n-1 indexs

// So here i take l and r two pointer then , do transverse from l to r check for fartherest r== higher Right idx and next l==lower , 
// Here we update . and also calculate that l to r how many jumps actual;y we require to reach to it .. So by thsi we reach end and return jumps 

// 

class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;

        int jumps =0;
        int l =0,r=0;
        while(r<nums.length-1){
            int nextR = 0;
            for(int i=l;i<=r;i++){
                nextR = Math.max(nextR,nums[i]+i);
            }
            l=r+1;
            r = nextR;
            jumps++;
        }
        return jumps;
    }
}
