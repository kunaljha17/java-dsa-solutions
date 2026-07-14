//Approach 1 
//2 pointer approach 
//store previous char 
//read with i next char 
//if equal ith == prevChar  , just count++
//if not equal then , store into input array at start id , we actaully need jth pointer or charsIdx to write original chars[] 
//then , check count >1 then store in array as single num in [] so make string then so on
//rest count = 1 and update prevChar now 
//at last we only store count of last group char , not write in chars .. so using j write pointer write chars last group
// return charsIdx or j as a result .. 


class Solution {
    public int compress(char[] chars) {
       int count = 1;
       char prevChar = chars[0];
       int charsIdx = 0;
       for(int i = 1;i<chars.length;i++){
        if(chars[i] == prevChar){
            count++;
        }else{
            chars[charsIdx++] = prevChar;
            //count
            if(count>1){
                String countStr = Integer.toString(count);
                for(int k = 0;k<countStr.length();k++){
                    chars[charsIdx++] = countStr.charAt(k);
                }
            }
            count = 1;
            prevChar = chars[i];
        }
       }
       // for last group
       chars[charsIdx++] = prevChar;
       if(count>1){
         String countStr = Integer.toString(count);
         for(int k = 0;k<countStr.length();k++){
          chars[charsIdx++] = countStr.charAt(k);
       }
    }
    return charsIdx;
 }
}



//approach 2 
// Uses extra space (ArrayList)

class Solution {
    public int compress(char[] chars) {
       List<Character> temp = new ArrayList<>();
       for (char c : chars) temp.add(c);
       temp.add('*'); //dummy char for read last char
       int n = temp.size();
       int i = 0;
       int count = 1;
       for (int j = 1; j < n; j++) {
           if (temp.get(j) == temp.get(j - 1)) {
               count++;
           } else {
               chars[i++] = temp.get(j - 1);
               if (count >1) {
                   String len = Integer.toString(count);
                   for (char c : len.toCharArray()) {
                       chars[i++] = c;
                   }
               }
               count = 1;
           }
       }
       return i;
    }
}
