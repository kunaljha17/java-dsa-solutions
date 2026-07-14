class Solution {
    public int compress(char[] chars) {
        int j = 0;
        int count = 1;
        char prevChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == prevChar) {
                count++;
            } else {
                chars[j++] = prevChar;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int k = 0; k < countStr.length(); k++) {
                        chars[j++] = countStr.charAt(k);
                    }
                }
                prevChar = current;
                count = 1;
            }
        }
        chars[j++] = prevChar;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (int k = 0; k < countStr.length(); k++) {
                chars[j++] = countStr.charAt(k);
            }
        }
        return j;
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
