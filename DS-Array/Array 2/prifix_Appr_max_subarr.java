import java.util.*;

public class prifix_Appr_max_subarr {

    public static void maxAndMinSubarrays(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        int sum =0;
        prefix[0]=numbers[0];

        // calculate prefix array
        for(int i =1;i<prefix.length;i++){
           prefix[i] = prefix[i-1] +numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                 sum =start==0?prefix[end]: prefix[end] -prefix[start-1];
               
                System.out.println(" =>Sum of this sub array is :" + sum);
                if (sum > maxSum) {
                    maxSum = sum;
                }
                System.out.println();
            }
            System.out.println();

        }
        System.out.println("Maximum in sum of sub array is :" + maxSum);

         }

   
        public static void kadanes(int numbers[]){
            int ms = Integer.MIN_VALUE;
            int cs = 0;

            for(int i = 0 ; i<numbers.length;i++){
                cs = cs + numbers[i];
                   if(cs<0){
                    cs = 0;
                   }
                   ms = Math.max(cs, ms);
            }

            System.out.println("Our max subarray sum is : "+ ms);

        }
    
         public static void main(String[] args) {

        int num[] = { -2,-3,4,-1,-2, 1,5,-3};
        // maxAndMinSubarrays(num);
        kadanes(num);

    }
}
