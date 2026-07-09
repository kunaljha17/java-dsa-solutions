

//Approach 1 .
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
                //m x n = total element
        int row = matrix.length;
        int col = matrix[0].length;
       int low = 0;
       int high = row*col-1; // treating 2D matrix as 1D array becz they are golabaly sort
       while(low<=high){
        int mid = low +(high-low)/2;
        int newRow = mid/col;
        int newCols = mid%col;
        if(matrix[newRow][newCols] == target) return true;
        else if(matrix[newRow][newCols]<target) low = mid +1;
        else high = mid -1;
       }
       return false;

    }
}

//Time Complexity: O(log(m × n))
// O(1) space complexity
//Aproach 2 is also there 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length-1;
        int n = matrix[0].length;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(matrix[mid][n-1] == target) return true;
            else if(matrix[mid][n-1]>target) j=mid-1;
            else i = mid+1;
        }
        int row = i;
        if(row == matrix.length)
         return false;
        int low  = 0; 
        int high = n-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
        
    }
}

