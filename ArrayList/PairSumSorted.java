import java.util.*;

public class PairSumSorted {

    //brute force -->O(n^2) here no need of sorted array or arraylist 
    public static boolean pairSum(ArrayList<Integer> arr ,int target){
        for(int i = 0;i<arr.size();i++){
            for(int j = i+1;j<arr.size();j++){
                if (arr.get(i)+arr.get(j)==target) {
                    System.out.println("["+arr.get(i)+" "+arr.get(j)+"]");
                    return true;
                }
            } 
        }
        return false;
    }

    //Optimize code of Pair sum O(n) need of sorted array here
    public static boolean OptimzPairSum(ArrayList<Integer> arr ,int target){
        int Lp =0,Rp=arr.size()-1;
        while (Lp<Rp) {
            int sum = arr.get(Lp)+arr.get(Rp);
            if (sum ==target) {
                 System.out.println("["+arr.get(Lp)+" "+arr.get(Rp)+"]");
                return true;
            }
            else if (sum<target) {
                Lp++;
            }else{
                Rp--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
          ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);
        arr.add(10);
         
        System.out.println(OptimzPairSum(arr, 8));
        
    }
}
