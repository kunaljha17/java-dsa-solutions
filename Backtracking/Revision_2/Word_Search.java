//Approach is Simple, 
//Search One char in board then move idx to to search chars in board of words
//First think for base cases there search not possible then , 
// For used only once 
//Here we have to define base case , Search Like DFS . then . found is true it return true . while restoring vis false.

class Solution {

    public boolean CharSearch(String word ,boolean[][] vis,char[][]board ,int X ,int Y , int idx){
        if(idx == word.length()) return true;

         if( X<0 || Y<0 || X>=board.length || Y>=board[0].length || vis[X][Y]) return false;

         if(word.charAt(idx) != board[X][Y]) return false;

         vis[X][Y]=true;
         boolean found = CharSearch(word,vis,board,X+1,Y,idx+1) ||CharSearch(word,vis,board,X-1,Y,idx+1)||CharSearch(word,vis,board,X,Y+1,idx+1) ||CharSearch(word,vis,board,X,Y-1,idx+1);

        vis[X][Y]=false; //IMPORTANT Step , Restoring makes the current cell available for exploration in a different path.

        return found;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length,m = board[0].length;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                if(CharSearch(word,new boolean[n][m],board,i,j,0)){
                    return true;
                    }
                }
            }
        }
        return false;
    }
}
