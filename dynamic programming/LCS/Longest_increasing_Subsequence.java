package LCS;
import java.util.*;

public class Longest_increasing_Subsequence {

    public static int LCS_arr(int arr[], int newArr[]){
        int n = arr.length;
        int m = newArr.length;
        int dp[][] = new int[n+1][m+1];

        //initializationa as LCS 
        for(int i =0 ;i<n+1;i++){
            for(int j =0;j<m+1;j++){
                dp[i][j] = 0;
            }
        }
        //bottom UP 
        for(int i = 1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                if(arr[i-1]==newArr[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int LIS_Tab(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        int newArr [] = new int[hs.size()];
        int i =0;
        for (Integer num : hs) {
            newArr[i] = num;//Store unique element
            i++;
        }
        Arrays.sort(newArr);// sort new Array

        return LCS_arr(arr, newArr);

    }
    public static void main(String[] args) {
        int arr[] = {50,3,40,10,7,50,40,80};
        System.out.println(LIS_Tab(arr));
        //OUTput :- 4
    }
    
}
//javac LCS/Longest_increasing_Subsequence.java
//java LCS/Longest_increasing_Subsequence