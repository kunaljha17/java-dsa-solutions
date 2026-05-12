public class sudoku {

    public static boolean isSafe(int sudokuu [][] , int row ,int col , int digit){
        //col fix
        for(int i = 0;i<9;i++){
            if (sudokuu[i][col]==digit) {
                return false;
            }
        }
        //row fix
        for(int i =0;i<9;i++){
            if (sudokuu[row][i]==digit) {
                return false;
            }
        }
        
        //3x3 grid check
        int sRow =(row/3)*3;
        int sCol = (col/3)*3;
        for(int i =sRow;i<sRow+3;i++){
            for(int j = sCol;j<sCol+3;j++){
                if (sudokuu[i][j]==digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuuSolver(int sudokuu[][],int row,int col){
        if (row==9&&col==0) {
            return true;
        }
        //recurisve
        int nextRow = row, nextCol = col+1;
        if (col+1 ==9) {
            nextRow = row+1;
            nextCol = 0;
        }
        if (sudokuu[row][col] !=0) {
           return sudokuuSolver(sudokuu, nextRow, nextCol);
        }

        for(int digit= 1 ;digit<=9;digit++){
            if(isSafe(sudokuu , row,col,digit)){
                sudokuu[row][col] = digit;
                if(sudokuuSolver(sudokuu, nextRow, nextCol)){
                    return true;
                }
                sudokuu[row][col]=0;
            }
        }
        return false;
    }

    public static void printArr(int arr[][]){
        for(int i = 0 ; i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       int sudoku[][] = {
    {0, 0, 8, 0, 0, 0, 0, 0, 0},
    {4, 9, 0, 1, 5, 7, 0, 0, 2},
    {0, 0, 3, 0, 0, 4, 1, 9, 0},
    {1, 8, 5, 0, 6, 0, 0, 2, 0},
    {0, 0, 0, 0, 2, 0, 0, 6, 0},
    {9, 6, 0, 4, 0, 5, 3, 0, 0},
    {0, 3, 0, 0, 7, 2, 0, 0, 4},
    {0, 4, 9, 0, 3, 0, 0, 5, 7},
    {8, 2, 7, 0, 0, 9, 0, 1, 3}
};

        if (sudokuuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exist!!");
            printArr(sudoku);
        }
        else{
            System.out.println("Solution does not exist");
        }
        
    }
}
