//This is optimal solution
// <<-->> Other approaches too
// Sort + Compare	O(n log n)	O(n)	 
// HashMap	O(n)	O(k)	✅ Good (works for any characters)
// Nested loops	O(n²)	O(1)	❌ Avoid



class Solution {
    public boolean isAnagram(String s, String t) {
        int count[] = new int[26];

       if (s.length() != t.length()) {//check diffrent length
             return false;
            }
       
        for(int i = 0;i<s.length();i++){//one loop bcz same length ...
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
       for(int i =0;i<26;i++){
        if(count[i] >=1){
            return false;
        }
       }
       return true;
    }
}
