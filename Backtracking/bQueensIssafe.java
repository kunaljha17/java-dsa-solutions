public class bQueensIssafe {

    public static boolean isSafe(char board[][],int row , int col){

        //vertical
        for(int i=row-1;i>=0;i--){
           if(board[i][col] =='Q'){
            return false;
           }
        }
        //left diagonal upper
        for(int i = row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j]=='Q') {
                return false;
            }
        }
        //Right diagonal upper
        for(int i = row-1,j = col+1;i>=0&&j<board.length;i--,j++){
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;

    }
    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            printArr(board);
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board, row + 1);// function call itself
                board[row][j] = 'x';// backtracking step
            }
            
        }
    }
    public static void printArr(char arr[][]) {
        System.out.println("------chess board-------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count =0;
     public static void CountnQueens(char board[][], int row) {
        if (row == board.length) {
            count++;
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                CountnQueens(board, row + 1);// function call itself
                board[row][j] = 'x';// backtracking step
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        CountnQueens(board, 0);
        System.out.println("Total number of way :"+count);
    }
}
