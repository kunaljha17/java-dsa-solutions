 //first define moves 
//then define base case as exptVal reaches length square
//iterate each move and check valid moves then call 
//recursive to reach exptVal

class Solution {

    public boolean isValid(int grid[][],int moves[][], int row,int col, int exptVal){
        int n = grid.length;
        if(exptVal == n*n){
            return true;
        }

        for(int i = 0;i<moves.length;i++){
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n && grid[nextRow][nextCol]==exptVal){
                return isValid(grid , moves,nextRow,nextCol,exptVal+1);
            } 
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int moves[][] ={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        return isValid(grid,moves , 0,0,1);
    }
}
