//Appraoch is simple here we 
// check this k = Sum(0,j) - Sum(0,i);
// here  we have previous store value of Sum(0,i) in hashMap 
// We check this way if Sum(0,i) = Sum(0,j)-k does this exist in hashmap or not .
// then we calculate length of array by doing i - hm.get...
//also after calculating we store Sum(0,j) into hasmap for further check 

class Solution {
	public int longestSubarray(int[] arr, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int len = 0;
		hm.put(0, -1);
		for (int i = 0; i<arr.length; i++) {
			sum += arr[i];
			if (hm.containsKey(sum - k)) {
				len = Math.max(len, i - hm.get(sum - k));
			} if (!hm.containsKey(sum)) {
				hm.put(sum, i);
			}
		}
		return len;
	}
}


