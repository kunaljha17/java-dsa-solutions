import java.util.*;

public class Largest_num {

    public static int getLargest(int arr[]){
        int large =  Integer.MIN_VALUE;//-INFINITY
        int smallest = Integer.MAX_VALUE;//+INFINITY
        
        for(int i = 0;i<arr.length;i++){
            if (arr[i]>large) {
                large = arr[i];
            }
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }
        System.out.println("The smallest value is :"+smallest);
        return large;
    }
    public static void main(String[] args) {
        int number[] = {1,2,6,3,5};
        System.out.println("largest value in number array :"+getLargest(number));
        
    }
}
