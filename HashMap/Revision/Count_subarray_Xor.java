//Approach is simple , 
//we make hashmap to check does store prev subarray xor val 
//mean  understand this concept like 
              // x  ^ //k  = xor 
// we have   |-----,-----| this  we want subarry so , 
// x^k = xor , XOR both side by k then we get : x = xor^k 
// so we store into hashmap subarray xor , check by ending val xor with k then this is in hashmap then count + number of time x in hashmap


class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count =0;
        map.put(0,1);
        for(int i =0;i<arr.length;i++){
            xor ^=arr[i];
            int x = xor^k;
            if(map.containsKey(x)){
                count += map.get(x);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
}
