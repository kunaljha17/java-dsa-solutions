import java.lang.reflect.Array;
import java.util.Arrays;

public class First_letter_Cap {

    public static String ToCapitalString(String str) {
        StringBuilder sb = new StringBuilder("");

        sb.append(Character.toUpperCase(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String CompressionStr(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 &&str.charAt(i) == str.charAt(i + 1)) {//While giving condn remmeber condition check from left to right
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static int VowelCount(String str){
        int count =0;
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if ( ch =='a'||ch =='e'||ch =='i'||ch=='o'||ch =='u') {
                count++;
            }
        }
        return count;
    }

    public static void Check_anagrams(String str1 , String str2 ){
        if (str1.length() !=str2.length()) {
            System.out.println("Not Anagrams");
        }

       str1 = str1.toLowerCase();
       str2 = str2.toLowerCase();

       char str1Array[] = str1.toCharArray();
       char str2Array[] = str2.toCharArray();

       Arrays.sort(str1Array);
       Arrays.sort(str2Array);

      boolean result =  Arrays.equals(str1Array, str2Array);

      if (result) {
        System.out.println("The given Strings are anagrams");
      }
      else{
        System.out.println("Not Anagrams");
      }
    }

    public static void main(String[] args) {
        // String str = "hi , i am kunal jha";
        // System.out.println(ToCapitalString(str));

        // String comp = "aaabbcccdd";
        // System.out.println(CompressionStr(comp));
          
        // String str = "Aiple";
        // System.out.println(VowelCount(str));

        Check_anagrams("listen", "silent");

    }
}
