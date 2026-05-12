import java.util.HashMap;

public class total_subarray_Sum_equals_k {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        int k = -10;
        int sum = 0;
        int subarrays = 0;
        hm.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - k)) {
                subarrays += hm.get(sum - k);
            }
                hm.put(sum - k, hm.getOrDefault(sum, 0) + 1);
             
        }
        System.out.println("Number of subarray sum of " + k + " is : " + subarrays);
    }
}
