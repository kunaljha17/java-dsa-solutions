public class SprialQ {

    public static void PrintSpiral(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix.length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        System.out.println();

    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        // O(n^2) Time complexity
        // for(int i=0;i<matrix.length;i++){
        // for(int j = 0;j<matrix[0].length;j++){
        // if (i==j) {
        // sum +=matrix[i][j];
        // }
        // else if (i+j==matrix.length-1) {
        // sum +=matrix[i][j];
        // }
        // }
        // }
        // return sum;

        // O(n) Time complexity
        for (int i = 0; i < matrix.length; i++) {
            // PD
            sum += matrix[i][i];
            // SD
            if (i != matrix.length - 1 - i) { // (j = matrix.length-1-i)
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        // PrintSpiral(matrix);
        System.out.println(diagonalSum(matrix));
    }
}








//MY versionn Approach 1

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length ;
        int endCol = matrix[0].length ;
        List<Integer> list = new ArrayList<>();

        while (startRow < endRow && startCol < endCol) {
            if(startRow==endRow-1){
                for(int i = startCol;i<endCol;i++){
                    list.add(matrix[startRow][i]);
                }
                break;
            }
            if(startCol==endCol-1){
                for(int i = startRow;i<endRow;i++){
                    list.add(matrix[i][startCol]);
                }
                break;
            }
            for (int i = startCol; i < endCol-1; i++) {
                list.add(matrix[startRow][i]);
            }
            for (int i = startRow; i < endRow-1; i++) {
                list.add(matrix[i][endCol-1]);
            }
            for (int i = endCol-1; i >startCol; i--) {
                list.add(matrix[endRow-1][i]);
            }
            for (int i = endRow-1; i > startRow; i--) {
                list.add(matrix[i][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return list;
    }
}



//Approach 2 for spiral matrix
public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // Top Row
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }

            // Right Column
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }

            // Bottom Row
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    list.add(matrix[endRow][i]);
                }
            }

            // Left Column
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return list;
    }
