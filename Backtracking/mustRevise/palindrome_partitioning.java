// we have to check for every psossible cuts in string so
// in helper first define base case then 
//use for loop for if valid cuts we get means left substring is palindrome 
//then , check for right substring ... by passing new right side as a string ..
//and so on./...


class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r =  s.length()-1;
        while(l<=r){
            char x = s.charAt(l);
            char y = s.charAt(r);
            if(x != y){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public void helper(String str  ,List<String> ls ,List<List<String>> ans ){
        if(str.length() ==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
      
      for(int i =0;i<str.length();i++){
       String subStr = str.substring(0,i+1);
       if(isPalindrome(subStr)){
        ls.add(subStr);
        helper(str.substring(i+1), ls,ans);
        ls.remove(ls.size()-1);
       }
       
      }
    }
    public List<List<String>> partition(String s) {
         List<List<String>> ans = new ArrayList<>();
         helper(s,new ArrayList<>(),ans);
         return ans;
    }
}
