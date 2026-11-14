class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashSet<Character> hs = new HashSet<>();
        int j =0;
        int k =0;
        int maxLen = 0;
        while(k<n && j<=k){
            char ch = s.charAt(k);
            if(!hs.contains(ch)){
                hs.add(ch);
                k++;
            }else{
                hs.remove(s.charAt(j); // here we to remove last jth char while srinking window
                j++;
            }
            maxLen = Math.max(maxLen,k-j);
        }
        return maxLen;
    }
}
