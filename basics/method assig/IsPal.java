public class IsPal {

    public static int reverse(int n){
        int lastD;
        int revsNum=0;
        
        while(n>0){
            lastD = n%10;
            revsNum = revsNum*10 +lastD ;
            n= n/10;
             
        }
        return revsNum;
    }

    public static boolean isPalandrome(int a){
        if(reverse(a)==a){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(isPalandrome(1231));
        
    }
}
