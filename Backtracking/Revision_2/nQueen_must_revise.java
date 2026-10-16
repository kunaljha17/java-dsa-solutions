//Here  ,step wise i explain what i think for doing solve this problem 
// First i think that how do i track Queen 'Q' So , i make 2D board by given n length ,
// then initailize with '.' initially , then i make ans ArrayList that store final ans ,
// after i think that i make all in this one main function so i think that does i make one function that take board , ans, row number to 
//Find valid position for Queen .
// So first think for base case that when i will last row then add current one board all positioned Queen into my ans arrayList 
// after i make traverse to all column to find  valid or safe position for queen .
//check every coor of curr row with isValid funtion there i define valid psoition for queen . 
//As i know queen go top to down So , I make sure to search Queen in left dia and right dia and vertical upward ..
// at last when all possible queen with DFS like completed then backtrack and search for another way to position queen in board

// at last i got store all board possible for queen 

class Solution {

    public boolean isValid(int row , int col ,char[][]board ){
        //Left Diagonal
        for(int i = row-1,j =col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //Roght Diagonal
        for(int i = row-1,j = col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Vertical
        for(int i = row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        return true;
    }

    public void boards(char[][] board,List<List<String>> ans,  int row){
         
        if(row == board.length){
            ans.add(QueensInRow(board));
            return;
        }

            for(int j = 0;j<board.length;j++){
                 if(isValid(row,j,board)){
                    board[row][j] = 'Q';
                    boards(board,ans,row+1);
                    board[row][j] = '.';
                 }
            }
         
    }

    public List<String> QueensInRow(char[][] board){
        List<String> ls = new ArrayList<>();
          for(int i =0 ;i<board.length;i++){
            ls.add(new String(board[i])); // here just pass char row to add in list
          }
          return ls;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; 

        for(int i =0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
    List<List<String>> ans = new ArrayList<>();
    boards(board,ans,0);
    return ans;

    }
}
