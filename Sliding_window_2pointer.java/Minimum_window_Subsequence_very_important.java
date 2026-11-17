//Approach :
// Pass 1: Forward traversal(Start matching characters of s2 in s1.,Move forward until all characters of s2 are matched.,You now have a valid window's ending position.)
// Pass 2: Backward traversal(Start from the ending position.,Move backward through s1.,Match s2 in reverse order.,This gives you the earliest possible starting position for that ending position.)
// Repeat Update the minimum window. , Continue searching for another valid subsequence.


class Solution {
	public String minWindow(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		int minLen = Integer.MAX_VALUE;
		int minStart = -1;
		int i = 0;
		while (i < n) {
		 
			int r = i, k = 0;
			while (r < n && k < m) { //forward
				if (s1.charAt(r) == s2.charAt(k))
					k++;
				r++;
			}
			if (k < m) break; //not valid subsequence
			int endIdx = r - 1;//store index
			k = m - 1;//for backward traversal we re initilise
			r = endIdx; // for backward ....
			while (r >= 0 && k >= 0) { //backward
				if (s1.charAt(r) == s2.charAt(k))
					k--;
				r--;
			}
			int startIdx = r + 1; //store start index
		 
			if (endIdx - startIdx + 1 < minLen) { // compare and update 
				minLen = endIdx - startIdx + 1; // update minlen
				minStart = startIdx; // store start index
			}
		 
			i = startIdx + 1;
		}
		
		
		return minStart == -1 ? "" : s1.substring(minStart, minStart + minLen);
	}
}
