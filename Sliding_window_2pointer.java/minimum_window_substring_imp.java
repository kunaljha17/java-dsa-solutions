class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];

        for(char ch :t.toCharArray()){ //store frequency
            freq[ch]++;
        }
        int n = t.length();
        int m = s.length();
        int i =0,j =0;
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while(j<m){
            if(freq[s.charAt(j)]>0){ //first expand onlyy
                count++;
            }
            freq[s.charAt(j)]--;
            while(count == n){ // This is for srinking
                 if(minLen>j-i+1){ //check does new substring length is smaller .?
                    minLen = j-i+1;
                    start = i; //store startind idx
                 }
                 freq[s.charAt(i)]++; // move pointer i so increase freq
                 if(freq[s.charAt(i)]>0){ // if freq current positive haii count decrease ..eska mtlb srink jada ho gaya
                    count--;
                 }
                 i++;
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE) return "";
        String ans = s.substring(start , minLen + start);
        return ans;
    }
}
