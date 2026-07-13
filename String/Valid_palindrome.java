//Optimal solution no extra space use ....
//two pointer approach used

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r =  s.length()-1;
        while(l<=r){
            char x = s.charAt(l);
            char y = s.charAt(r);

            if(x>='A' && x<='Z') x = Character.toLowerCase(x);
            if(y>='A' && y<='Z') y = Character.toLowerCase(y);

           if(!((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9'))){
                l++;
                continue;
            }
            if(!((y >= 'a' && y <= 'z') || (y >= '0' && y <= '9'))){
                r--;
                continue;
            }
            if(x != y){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
