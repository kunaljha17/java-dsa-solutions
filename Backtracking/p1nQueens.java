public class p1nQueens{

    public static void nQueens(char board[][],int row){
        if (row == board.length) {
            printArr(board);
            return;
        }
        //column loop
        for(int j =0;j<board.length;j++){
            board[row][j] = 'Q';
            nQueens(board, row+1);//function call itself
            board[row][j]='.';//backtracking step
        }
    }

    public static void printArr(char arr[][]){
        System.out.println("------chess board-------");
        for(int i = 0;i<arr.length;i++){
            for(int j =0;j<arr.length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
      int n = 2;
      char board[][] = new char[n][n];
      
      for(int i=0 ; i<board.length;i++){
        for(int j =0;j<board.length;j++){
            board[i][j]='.';
        }
      }

      nQueens(board, 0);
      //
    }
}