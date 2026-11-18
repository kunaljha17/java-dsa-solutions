//Appproach
// first i think for hashSet but , when i do srink , there i have to remove  So its remove that char not by increasing 
// l effect  anything , So then i use HashMap . to remove frequency of char
// Only use expand , srink (store)



class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int l =0,r =0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()==3){
                count += s.length() - r;
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return count;
    }
}

//Approch 2 

class Solution {
    public int numberOfSubstrings(String s) {
        int[] hist = { -1, -1, -1 }; // this is three var storage (store index of char)
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            hist[s.charAt(i) - 'a'] = i;
            if (hist[0] != -1 && hist[1] != -1 && hist[2] != -1) { // here this check that all three are in current substring
                int min = Math.min(hist[0], Math.min(hist[1], hist[2]));
                count += min + 1;  
            }

        }
        return count;
    }
}
