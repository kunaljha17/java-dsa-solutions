//Approach is good, 
//here i define one palindrome function , there i just check simple match of left char with right char , 
//we match two bcz if length is even or odd both so i have to do size1 and size2 both ,
//then take max , finding left idx and right indx of substring we want then at the end i return 
// the expand-around-center approach



class Solution {
    public String longestPalindrome(String s) {
        int left = 0,right =0;
        for(int i =0;i<s.length();i++){
            int  size1 = palindrome(s,i,i); // Odd-length palindrome
           int  size2 = palindrome(s,i,i+1); //Even-length palindrome
          int  maxSize = Math.max(size1,size2);
            if(right-left < maxSize){
                left = i - (maxSize-1)/2;
                right = i + maxSize/2;
            }
        }
        return  s.substring(left,right+1);
    }

    public int palindrome(String str, int left,int right){
        while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right-left -1;
    }
}
