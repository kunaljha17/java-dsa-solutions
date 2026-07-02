package LCS;

public class String_conversion {

    public static int StrCon_I_D(String str1, String str2){

        int n = str1.length();
        int m = str2.length();
        
        int Lcs_str1_str2 = Longest_common_subsequence.LCS_tab(str1, str2);

        int delete_op = n-Lcs_str1_str2;
        int insert_op = m-Lcs_str1_str2;
        return delete_op +insert_op;
    }
    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        System.out.println(StrCon_I_D(str1, str2));
        //OuTput = 3
        
    }
}
//javac LCS/String_conversion.java
//java LCS/String_conversion