// Input: maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
// Output: ["DDRDRR", "DRDDRR"]
// Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3)


in this i make invalid row and col check .. return immediately .
check for base case does row col reaches to n-1, n-1 destination .then add current list and return 
backtrack remove added Path add new path ...by following we get another path when row col reached.
also make previous path visited by giving invalid 0 closed input after all these we again reinitialize with 1 for next path .

class Solution {
    
    public void helper(int maze[][],StringBuilder str,ArrayList<String> list ,int row ,int col){
        
        if(row==-1||col==-1||row==maze.length||col==maze.length||maze[row][col]==0){
            return;
        }
        if(row ==maze.length-1&& col==maze.length-1){
            list.add(str.toString());
            return;
        }
        maze[row][col] = 0;

        str.append('D');
        helper(maze,str,list,row+1,col );
        str.deleteCharAt(str.length()-1);
        
        str.append('L');
        helper(maze,str,list,row,col-1 );
        str.deleteCharAt(str.length()-1);
        
        str.append('R');
        helper(maze,str,list,row,col+1 );
        str.deleteCharAt(str.length()-1);
        
        str.append('U');
        helper(maze,str,list,row-1,col );
        str.deleteCharAt(str.length()-1);
        
        maze[row][col] = 1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> list = new ArrayList<>();
        helper(maze,new StringBuilder(""),list,0,0 );
        return list;
    }
}































public class RatMaza {

    public static int numRatMaze(int maze[][], int i, int j) {
        if (i == maze.length - 1 && j == maze.length - 1) {
            return 1;
        }
        if (i == -1 || j == -1 || i == maze.length || j == maze.length) {
            return 0;
        }
        if (maze[i][j] == 0) {
            return 0;
        }
        int w1 = numRatMaze(maze, i, j - 1 );
        int w2 = numRatMaze(maze, i, j + 1 );
        int w3 = numRatMaze(maze, i - 1, j );
        int w4 = numRatMaze(maze, i + 1, j );

        return w1 + w2 + w3 + w4;
    }

    public static void main(String[] args) {
        int n = 4;
        int maze[][] = new int[n][n];
        // initialization maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i == 1 && j == 0 || i == 1 && j == 2 || i == 3 || j == 1) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }

        System.out.println(numRatMaze(maze,0,0));

    }
}
