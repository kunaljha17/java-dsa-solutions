import java.util.ArrayList;

public class PairSumRotSort {

    //brute force normal O(n^2) which use normally

    // In this Optimize code of rotated pair sum problem Time complexity O(n);
    //Optimize for this case 
    public static boolean RotatedSortedPairSum(ArrayList<Integer> arr , int target){
        int n = arr.size();//size of arraylist
        int Lp=-1,Rp=n-1;
        for(int i = 0;i<n;i++){
            if (arr.get(i)>arr.get(i+1)) {
                Lp =i+1;
                Rp = i;
                break;
            }
        }

        while (Lp!=Rp) {
            int sum = arr.get(Lp) +arr.get(Rp);
            if (sum ==target) {
                System.out.println("["+arr.get(Lp) +" "+ arr.get(Rp)+"]");
                return true;
            }
            else if (sum<target) {
                Lp = (Lp+1)%n;//Important formula use when want array index move only inside array not out of bound error ... it like loop jump
            }else{
                Rp= (n+Rp-1)%n;//similar left loop run
            }
        }
        return false;
    }


    public static void main(String[] args) {
            //arr[] = {14,16,18,8,10,12};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(14);
        arr.add(16);
        arr.add(18);
        arr.add(8);
        arr.add(10);
        arr.add(12);
        
        System.out.println(RotatedSortedPairSum(arr,28));
        
    }
}
  