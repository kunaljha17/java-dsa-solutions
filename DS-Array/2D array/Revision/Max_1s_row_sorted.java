//three approach for this problem 
//first one is just brute force and second is better ,



//This is just better approach
class Solution {
    
    public int MaxOnes(int[][]arr, int i){
        int low =0,high = arr[0].length-1;
        
        while(low<=high){
            int mid = low +(high -low)/2;
            if(arr[i][mid]==1){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return arr[0].length-low;
    }
    
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length,m = arr[0].length;
         
        int idx = -1;
        int maxOnes = 0;
        for(int i =0;i<n;i++){
            int CurrSum = MaxOnes(arr,i);
            if(maxOnes<CurrSum){
                maxOnes = CurrSum;
                idx = i;
            }
            if(maxOnes == m) return idx;
        }
        return idx;
    }
}
