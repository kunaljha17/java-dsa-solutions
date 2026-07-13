// Scan every index.
// Try matching part.
// If found:
// delete it
// restart from beginning.
// Otherwise continue.



class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while(i < str.length()){
            int j = 0;
            int temp = i;
            while(j<part.length() && temp<str.length() && str.charAt(temp) == part.charAt(j)){
                temp++;
                j++;
            }
            if(j == part.length()){
                str.delete(i,temp);
                i = 0;
                continue;
            }
            i++;
        }
        return str.toString();
    }
}



//but we can also do with using library 

while(s.contains(part)){
    s = s.replaceFirst(part, "");
}


//OR 

while(true){
    int idx = s.indexOf(part);

    if(idx==-1) break;

    s = s.substring(0,idx)+s.substring(idx+part.length());
}
