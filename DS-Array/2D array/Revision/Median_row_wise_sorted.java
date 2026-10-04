//Approach brute force 
// Time complexity is m*n + n*mlog(n*n)

class Solution {
    public int median(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = mat.length,m = mat[0].length;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                list.add(mat[i][j]);
            }
        }
        Collections.sort(list);
        int idx = n*m/2;
        return list.get(idx);
        
    }
}


//Optimal approach 
// O(n × log(m) × log(max-min))
// binary search on the answer + upper bound in each row
//here i count how many number is less than mid value then, for finding less value i use upper bound , 
//And lessCuont function i use for iterate each row and calculate upper bound of each row and sum of total , then compare that is less is less than leftsize number 
//then move low = mid +1 and i get more then high = mid -1;
// i don't want equal to left size and Also one thing in problem i there is given that size is alway a odd so we have single median val.




class Solution {
    public int upperBound(int [][] mat ,int target,int row){
        int low =0,high =mat[0].length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(mat[row][mid]<=target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public int lessCount(int[][]mat,int mid){
         int sum = 0;
         for(int i =0;i<mat.length;i++){
            sum += upperBound(mat,mid,i);
         }
         return sum;
    }
    
    public int median(int[][] mat) {
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        for(int i =0;i<n;i++){
            low = Math.min(low,mat[i][0]);
            high = Math.max(high,mat[i][m-1]);
        }
        
        int leftSize = n*m/2;
        
        while(low<=high){
            int mid = low +(high - low)/2;
            int smallerCount = lessCount(mat,mid);
            if(smallerCount<=leftSize){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}


