// Subarray Sum = Current Prefix − Previous Prefix

// k = currentPrefix − previousPrefix

// previousPrefix = currentPrefix − k


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




// 1. Use Prefix Sum + HashMap.

// 2. HashMap stores:
//    prefixSum -> frequency

// 3. Initialize:
//    map.put(0, 1)
//    (handles subarrays starting from index 0)

// 4. For each element:
//    sum += nums[i]

// 5. Search:
//    if(map contains (sum - k))
//        ans += map.get(sum - k)

// 6. Why sum-k?
//    currentPrefix - previousPrefix = k
//    => previousPrefix = currentPrefix - k

// 7. After searching, store current prefix:
//    map.put(sum, map.getOrDefault(sum, 0) + 1)

// 8. Never store (sum-k), only store current sum.

// 9. Frequency is important because the same prefix sum may occur multiple times.

// 10. Time: O(n)
//     Space: O(n)
