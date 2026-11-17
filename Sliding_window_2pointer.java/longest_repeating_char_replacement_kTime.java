//This problem has only three main task to do :
//first think for edge case , where left pointer we have to srink 
//expand right pointer and also check that current substring is valid or not 
// Store maxLen for ans . Also for this question we have to store frequency
// 1. expand ,2. srink , 3.store


class Solution {
    public int characterReplacement(String s, int k) {
        int l =0,r =0;
        int maxFreq =0,maxLen =0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            maxFreq = Math.max(maxFreq,map.get(s.charAt(r)));
            if((r-l+1)-maxFreq>k){
                map.put(s.charAt(l),map.get(s.charAt(l)-1));
                if(map.get(s.charAt(r))==0)map.remove(s.charAt(r));
                l++;
            }
            maxLen = Math.max(maxLen,l-r+1);
            r++;
        }
        return maxLen;
    }
}
