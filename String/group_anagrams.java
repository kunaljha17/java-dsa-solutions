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
        if(count[i] != 0){
            return false;
        }
       }
       return true;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> ls = new ArrayList<>();
        for(int i =0;i<strs.length;i++){
            ls.add(strs[i]);
        }
        List<List<String>> ansList = new ArrayList<>();
        ansList.add(ls);
        ls = new ArrayList<>();
        
        if(ansList.get(0).size()>0){
        ls.add(ansList.get(0).get(0));
        ansList.get(0).remove(0);
        }
       
         while(ls.size() > 0 ){
            int j = 0;
            while( j< ansList.get(0).size()){
                if(isAnagram(ls.get(0),ansList.get(0).get(j))){
                ls.add(ansList.get(0).get(j));
                ansList.get(0).remove(j);
                }else{
                    j++;
                }
            }
            ansList.add(ls);
            ls = new ArrayList<>();
            if(ansList.get(0).size()>0) {
                ls.add(ansList.get(0).get(0));
                ansList.get(0).remove(0);
             }
        }
        ansList.remove(0);
    return ansList;
  }
}



// //approach 2
// using hashmap 
//   sort string then add as a key then 
//   add original string 
//   and so on return final hashmap as a arrylist
