import java.util.*;

public class recur {

    public void f(ArrayList<Integer> arr ,int idx , int sum, int target ,int []num){
        
        if(sum == target){
            System.out.println(arr);
            return;
        }
        if(idx == num.length) return;

        arr.add(num[idx]);
        sum +=num[idx];
        f(arr, idx+1, sum, target,num);// Take the current element
        arr.remove(arr.size()-1);// Backtrack
        sum -= num[idx];
        f(arr, idx+1, sum, target,num); // Do not take the current element
    }

    public boolean OneF(ArrayList<Integer> arr ,int idx , int sum, int target ,int []num){
        
        if(sum == target){
            System.out.println(arr);
            return true;
        }
        if(idx == num.length) return false;

        arr.add(num[idx]);
        sum +=num[idx];
        if(OneF(arr, idx+1, sum, target,num)){
            return true;
        }
        arr.remove(arr.size()-1);// Backtrack
        sum -= num[idx];
        if(OneF(arr, idx+1, sum, target,num)){ return true;} // Do not take the current element
        return false;
    }

    public static void main(String[] args) {
        
    }
}
