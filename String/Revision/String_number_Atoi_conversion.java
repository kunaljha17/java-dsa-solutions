class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && (s.charAt(i) == ' '))
            i++;
        int sign = 1;
        if (i != n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }
        long ans = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0'); // here '0' start from 48 so '5' ==53 , that why minus char - '0'
            if (ans > Integer.MAX_VALUE){
                if(sign == -1) return Integer.MIN_VALUE;   //this is for stoping unnecessary calulation and also stopping long overflow ;
                else return Integer.MAX_VALUE;
                }
            i++;
        }
        ans *= sign;
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) ans;
    }
}
