//Approach : previously  i do peak in 1 D array same concept but here i do eliminate col by first get mid of col ,
//then do search max element in that column , when i get max then do check with left and right val if satisfy the condition then return ,
//if curr mid is less than left then eliminate right part and move toward right ,
//if right is greater then eleiminate left and move toward right by low = mid+1

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0,high = mat[0].length-1;
        while(low<=high){
            int col = low + (high-low)/2;
            int maxIdx = 0;
            for(int i =0;i<mat.length;i++){
                if(mat[i][col]>mat[maxIdx][col]){
                    maxIdx = i; // for finding max index 
                }
            }
            int left = (col-1>=0)?mat[maxIdx][col-1]:-1;
            int right = (col+1<mat[0].length) ?mat[maxIdx][col+1]:-1;
            
            if(left<mat[maxIdx][col] && right < mat[maxIdx][col]) return new int[]{maxIdx ,col};

            else if(left >mat[maxIdx][col]) high = col-1;
            else low = col+1;
        }
        return new int[]{-1,-1};
    }
}

 
