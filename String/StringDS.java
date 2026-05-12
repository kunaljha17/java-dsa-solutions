public class StringDS {

    public static boolean ispalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                // not a palindrome
                System.out.println("The given string is not palindrome");
                return false;

            }
        }
        System.out.println("The given string is palindrome");
        return true;
    }

    // Q2 M-1
    // public static int ShortestLength(String str) {
    // int x = 0, y = 0, i = 0;
    // int n = str.length();
    // while (n > 0) {
    // char C = str.charAt(i);
    // if (C == 'E') {
    // x++;
    // } else if (C == 'W') {
    // x--;
    // } else if (C == 'N') {
    // y++;
    // } else if (C == 'S') {
    // y--;
    // }
    // i++;
    // n--;
    // }
    // int shortpath = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    // return shortpath;
    // }

    // Q2 M2
    public static float Shortestpath(String str) {
        int x = 0, y = 0; 

        for(int i = 0;i<str.length();i++){
            char dir = str.charAt(i);
            if (dir == 'E') {
                x++;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        float shortpath = (float) Math.sqrt(X2+Y2);
        return shortpath;
    }

    public static String subString (String str , int si , int ei){
        String substr = "";
        for(int i = si; i < ei;i++){
            substr += str.charAt(i);
        }
        return substr;
    }

    public static String largeString(String str1[]){
       String largest = str1[0];
          for(int i = 1 ; i<str1.length;i++){
            if (largest.compareToIgnoreCase(str1[i])<0) {
                largest = str1[i];
            }
          }
        return largest;
    }

    

    public static void main(String[] args) {
        // String str = "WNEENESENNN";
        // ispalindrome(str);
        // System.out.println(Shortestpath(str));

        // System.out.println(subString(str, 0, 4));
        // System.out.println(str.substring(0,4));

      StringBuilder sb = new StringBuilder("");
      for(char ch = 'a';ch<='z';ch++){
        sb.append(ch);
      }//abcsefghijklmnopqrstvuxyz....
      //O(26)
      //O(n^2)-->Ins normal String datatype
    String str[] = {"apple" , "mango", "banana"};
      System.out.println(largeString(str));
    }
}
