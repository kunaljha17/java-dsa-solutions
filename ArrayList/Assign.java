import java.util.*;

public class Assign {

    // Q-1
    // public static boolean CheckIncAndDec(ArrayList<Integer> nums ){// Time
    // complexity O(n^2) ---> bad for this prblm
    // //inc
    // for(int i =1;i<nums.size();i++){
    // if (nums.get(0)<nums.get(1)) {
    // //monotonic inc
    // for(int j = i+1;j<nums.size();j++){
    // if (nums.get(i)>nums.get(j)) {
    // return false;
    // }
    // }
    // }
    // else{
    // //monotonic dec
    // for(int j = i+1;j<nums.size();j++){
    // if (nums.get(i)<nums.get(j)) {
    // return false;
    // }
    // }
    // }
    // }
    // return true;
    // }

    public static boolean CheckIncAndDec(ArrayList<Integer> nums) {// O(n)
        if (nums.size() <= 1) {
            return true;
        }
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < nums.size() - 1; i++) {// if not monotonic then both flag is false;
            if (nums.get(i) < nums.get(i + 1)) {
                inc = true;
            }
            if (nums.get(i) < nums.get(i + 1)) {
                dec = true;
            }
        }
        return inc || dec;// here if atleast one true then return true ;
    }

    // Q-2
    public static boolean isSafe(ArrayList<Integer> nums, int key) {
        int count = 0;
        int Nm1 = key - 1, Np1 = key + 1;
        for (int j = 0; j < nums.size(); j++) {
            if (key == nums.get(j)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        for (int j = 0; j < nums.size(); j++) {
            if (Nm1 == nums.get(j) || Np1 == nums.get(j)) {
                return false;
            }
        }
        return true;
    }

    public static void LonelyEle(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (isSafe(nums, nums.get(i))) {
                list.add(nums.get(i));
            }
        }
        if (list.size() == 0) {
            System.out.println("No lonely element exists");
        } else {

            System.out.println("Lonely element are :" + list);
        }
    }

    // Q3
    public static int OccurFreqKey(ArrayList<Integer> nums, int key) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> SearchedList = new ArrayList<>();
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) == key) {
                list.add(nums.get(i + 1));
            }
        }
        int target = list.get(0);
        
        int prevCount = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int Count = 0;
            if (!SearchedList.contains(list.get(i))) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) == list.get(j)) {
                        Count++;
                        
                    }
                }
            }
            SearchedList.add(list.get(i));
            if (prevCount < Count) {
                target = list.get(i);
                prevCount = Count;
            }
        }
        return target;
    }

    

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        int key =1;
        arr.add(1);
        arr.add(100);
        arr.add(200);
        arr.add(1);
        arr.add(100);
        System.out.println(OccurFreqKey(arr, key));
    }
}
