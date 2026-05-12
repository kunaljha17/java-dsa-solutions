// public class hollow_rect {
//     public static void main(String[] args) {
//         int n = 4;
//         for(int i= 1;i<=n;i++){
//             for(int j = 0;j<=n;j++){
//                 if(i==1||i==n||j==0||j==n){
//                     System.out.print("*");
//                 }
//                 else{
//                     System.out.print(" ");
//                 }
//             }
//             System.out.println();
//         }
//     }

// }

public class Pattern_Star {
    // Q1
    public static void hollow_rectangle(int totRows, int totCols) {
        for (int i = 1; i <= totRows; i++) {
            for (int j = 1; j <= totCols; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print('*');
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Q2
    public static void inverted_pyra(int row) {
        for (int i = 1; i <= row; i++) {
            // spaces
            for (int j = i; j < row; j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q3
    public static void inverted_numb_pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Q4
    public static void floyd_tria(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void Zero_one_tria(int n) {

        for (int i = 1; i <= n; i++) {
            int check = (i % 2 == 1) ? 1 : 0;
            for (int j = 1; j <= i; j++) {
                System.out.print(check);
                check = (check == 1) ? 0 : 1;
            }

            System.out.println();
        }
        /*
         * 1
         * 01
         * 101
         * 0101
         * 10101
         */
    }


    public static void butterfly(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= ((2 * n) - (2 * i)); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= ((2 * n) - (2 * i)); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void Solid_Rhombus(int n){
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    
    public static void hollow_Rhombus(int n){
        //spaces
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }


            //holloRectangle code
            for(int j = 1;j<=n;j++){ 
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print('*');
                } else {
                    System.out.print(" ");
                }
                  
            }
            System.out.println();
        }
    }

    public static void Diamond(int n){
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1 ;j<=((2*i)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i =n;i>=1;i--){
            for(int j = 1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1 ;j<=((2*i)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        // hollow_rectangle(4,5);
        // inverted_pyra(7);
        // inverted_numb_pyramid(5);
        // floyd_tria(5);
        // Zero_one_tria(5);
        // butterfly(4);
        // Solid_Rhombus(5);
        // hollow_Rhombus(5);
        // Diamond(7);

    }
}