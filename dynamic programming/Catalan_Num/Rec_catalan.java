// package Catalan_Num;

public class Rec_catalan {

    public static int Cat_rec(int n){
        if (n ==0||n ==1) {
            return 1;
        }

        int ans = 0;
        for(int i = 0;i<=n-1;i++){
            ans += Cat_rec(i)*Cat_rec(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n =4;
        System.out.println(Cat_rec(n));
    }
}
