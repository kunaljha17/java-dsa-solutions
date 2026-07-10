//Approach 1
// 1. Check if the first column contains any 0 → store in boolean col.
// 2. Traverse the matrix.
// 3. If matrix[i][j] == 0:
//       → matrix[i][0] = 0 (mark row)
//       → matrix[0][j] = 0 (mark column)
// 4. Traverse from Bottom → Top and Right → Left.
// 5. If matrix[i][0] == 0 OR matrix[0][j] == 0:
//       → matrix[i][j] = 0
// 6. Do NOT touch the first column during this traversal.
// 7. After processing each row, if col == true:
//       → matrix[i][0] = 0
// 8. First row & first column act as marker arrays.
// 9. Reverse traversal prevents markers from being overwritten.
// 10. Time: O(m×n), Space: O(1)


// 1. Read markers from first row & first column.
// 2. Zero all other cells.
// 3. Finally, zero the first column (using `col`)



public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col = false;

        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                col = true;
            }
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

         for(int i = n - 1; i >= 0; i--){ // bottom - top
            for(int j = m - 1; j >= 1; j--){//right - left
                if(matrix[i][0]==0){ //row as a marker check 
                    matrix[i][j] =0;
                }
                if(matrix[0][j]==0){//col as a marker check
                    matrix[i][j] =0;
                }
            }
            if(col){// 0th col fill in last bcz this is marker for row
                matrix[i][0] = 0;
            }
         }
    }

//Aproach 2
public void setZeroes(int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;
       boolean rows [] = new boolean[n];
       boolean cols [] = new boolean[m];

       for(int i = 0 ;i<n;i++){
        for(int j = 0;j<m;j++){
            if(matrix[i][j] == 0){
                rows[i] = true;
                cols[j] = true;
            }
        }
       }
       for(int i = 0 ;i<n;i++){
        for(int j = 0;j<m;j++){
            if(rows[i]||cols[j]){
                 matrix[i][j]=0;
            }
         }
       }
    }
