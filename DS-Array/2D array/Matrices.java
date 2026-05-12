import java.util.Scanner;

public class Matrices {

    public static boolean search(int matrix[][],int key){
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                 if (matrix[i][j]==key) {
                        System.out.print("Found at ("+i+","+j+")");
                         return true;                    
                 }
            }
        }
        System.out.println("Not found");
        return false;


    }

    public static int Largest(int matrix[][]){
        int large = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               if (large<matrix[i][j]) {
                large = matrix[i][j];
               }
            }
        }
        return large;

    }

    

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;
        Scanner sc = new Scanner(System.in);
        //input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        // search(matrix, 6);
       System.out.println( "largest element in matrix is: "+Largest(matrix));

    }
}
