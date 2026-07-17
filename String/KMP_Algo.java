✅ Match → len++, lps[i] = len, i++
✅ Mismatch + len > 0 → len = lps[len - 1] (same i)
✅ Mismatch + len == 0 → lps[i] = 0, i++

That's the whole LPS algorithm.


while (i < n) {     // Calculate lps array through this 
    if (pattern[i] == pattern[len]) {
        len++;
        lps[i] = len;
        i++;
    }
    else {
        if (len != 0) {
            len = lps[len - 1];   // don't move i
        } else {
            lps[i] = 0;
            i++;
        }
    }
}


// Longest happy prefix
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return "";
        int[] lps = new int[n];
        int len = 0; 
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int longestLength = lps[n - 1]; // last indx has Longest proper prefix equal to suffix
        return s.substring(0, longestLength);
    }
}


