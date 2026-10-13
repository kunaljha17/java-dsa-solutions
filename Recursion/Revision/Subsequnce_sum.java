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

// Base case: If sum == target, print the current subsequence and return true.
// Take: Add the current element and recursively search.
// Stop early: If the recursive call returns true, immediately return true without exploring other possibilities.
// Backtrack: If taking the element doesn't find a solution, remove it.
// Not take: Recursively search without the current element.

    
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



public int countF(ArrayList<Integer> arr, int idx, int sum, int target, int[] num) {

        if (sum == target) {
            return 1;
        }
        if (idx == num.length)
            return 0;

        arr.add(num[idx]);
        int l = countF(arr, idx + 1, sum + num[idx], target, num);
        arr.remove(arr.size() - 1);// Backtrack
        int r = countF(arr, idx + 1, sum, target, num); // Do not take the current element
        return l + r;
    }


    
    public static void main(String[] args) {
        
    }
}
