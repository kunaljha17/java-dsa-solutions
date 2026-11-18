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
