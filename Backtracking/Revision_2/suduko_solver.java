//In this i solve by normal iterative approach , here i use backtracking and recursion but , not for row and col , 
//i don't want too complication of normal problem ..

//Also i solve this previously by diffrent way , this time i solve by this approach


class Solution {

    public boolean isSafe(char[][]board ,char ch,int X,int Y){

        int rowBox = (X/3)*3;
        int colBox = (Y/3)*3; 
        //3x3 box
        for(int i =rowBox ; i<rowBox+3;i++){
            for(int j = colBox;j<colBox+3;j++){
                if(board[i][j] == ch) return false;
            }
        }
        //vertical
        for(int i = 0;i<board.length;i++){
            if(board[i][Y]==ch) return false;
        }

        //horizontal
        for(int i = 0;i<board.length;i++){
            if(board[X][i] == ch) return false;
        }
        return true;
    }

    public boolean helper(char[][] board){
         int n  = board.length;
         for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == '.'){
                    for(char k = '1';k<='9';k++){
                        if(isSafe(board,k,i,j)){
                            board[i][j] = k;
                            if(helper(board)) return true;
                             board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
         }
         return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        helper(board);

    }
}
