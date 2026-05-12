public class Assig2dArr {

    public static int CountNumIn2Darr(int arr[][],int target){
        int count = 0 ;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0 ;j<arr[0].length;j++){
                if (target == arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
   
    public static int SumOfRow (int arr[][], int rowNo){
        int sum = 0 ;
        for(int j = 0;j<arr[rowNo].length;j++){
            sum += arr[rowNo][j];
        }
        return sum;
    }

    public static void TransposeMatrix(int arr[][]){
    
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1 ;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]= temp;
            }
        }
           
    }

    public static void main(String[] args) {
        int num [] [] = {{23,34,7},{7,5,4},{23,4,5}};
        int rowNo = 1;
        System.out.println(SumOfRow(num, rowNo));
        
    }
}
