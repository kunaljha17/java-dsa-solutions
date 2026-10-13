
//By this i got TLE , but i know that this problem is optimize through using dp , Although this code is correct ,..
//Finally i come up with that . i have to write dp code for pass all test case

class Solution {
	
	public int countF(int idx, int sum, int target, int[] num) {
		
		 if(idx == num.length){
		     return sum == target?1:0;
		 }
		int l = countF(idx + 1, sum + num[idx], target, num);
		int r = countF(idx + 1, sum, target, num);  
		return l + r;
	}
	
	static int perfectSum(int[] arr, int target) {
		return new Solution().countF(0,0,target,arr);
	}
}
