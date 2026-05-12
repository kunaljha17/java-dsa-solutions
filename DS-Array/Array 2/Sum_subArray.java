public class Sum_subArray {


    public static void maxAndMinSubarrays(int numbers[]) {
        // int ts = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                int sum = 0;
                System.out.print("[");
                for (int k = start; k <= end; k++) {
                    // System.out.print(numbers[k] + ",");
                    sum  += numbers[k];
                }
                System.out.print("]");
                System.out.println(" =>Sum of this sub array is :" + sum);

                if (sum < minSum) {
                    minSum = sum;
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }

                // ts++;
                System.out.println();
            }
            System.out.println();

        }
        // System.out.println("Total sub array = " + ts);
        System.out.println("Minimum in sum of sub array is :" + minSum);
        System.out.println("Maximum in sum of sub array is :" + maxSum);

    }

    public static void main(String[] args) {

        int num[] = { 1, -2, 6, -1, 3 };
        maxAndMinSubarrays(num);

    }
}



// <<<<<--------->>>>>>>>

    // public static void minAndMax(int sum[]){
    // int maxSum = Integer.MIN_VALUE;
    // int minSum = Integer.MAX_VALUE;

    // for(int i =0;i<sum.length;i++){
    // if(sum[i]<minSum){
    // minSum = sum[i];
    // }
    // if(sum[i]>maxSum){
    // maxSum = sum[i];
    // }
    // }
    // System.out.println("Minimum sum of sub array is :"+minSum);
    // System.out.println("Maximum sum of sub array is :"+maxSum);
    // }