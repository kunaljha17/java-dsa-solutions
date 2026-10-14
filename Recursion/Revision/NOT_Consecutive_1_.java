//Here first i apply thorugh normal recursive approach , but i got TLE ,
//So optimization of recursive is Using dp . In dp normally we use memoization . So here i do store calculate val into dp[][] 2D array 
//when we found that this i already calculate earlier then ,Simply return here 


class Solution {
	
	public int validStr(int n, int Lp ,int[][] dp) {
		if (n == 0) {
			return 1;
		}
		
		if(dp[n][Lp] != -1) return dp[n][Lp];
		
		int pick = validStr(n - 1, 0,dp);
		int notPick = Lp==0?validStr(n-1,1 ,dp):0;
		return dp[n][Lp] = pick + notPick;
	}
	
	int countStrings(int n) {
	    
	    int[][] dp = new int[n+1][2];
	    for(int i =0;i<n+1;i++){
	        Arrays.fill(dp[i],-1);
	    }
	    
		return validStr(n, 0,dp);
	}
}
