public class Bit_mani {

    public static void Check_odd_even(int n ){
        int bitmask = 1;
        if ((n&bitmask)==0) {
            System.out.println("Even number");
        }
        else{
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n,int i ){
        int bitmask = 1<<i;
        int get  = n&bitmask;
        if (get !=0) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int setIthBit(int n , int i ){
        int bitmask = 1<<i;
        return n|bitmask;
    }

    public static int clearIthBit(int n , int i){
        int bitmask = ~(1<<i);
        return n&bitmask;
    }

    public static int updateIthBit(int n , int i ,int newBit){
        
       //M-1 
        // if (newBit ==1) {
        //     return setIthBit(n, i);
        // }
        // else{
        //     return clearIthBit(n, i);
        // }

        // M-2
        n = clearIthBit(n, i);
        int bitmask = newBit<<i;
        return n|bitmask;
    }

    public static int clearlastIthBit(int n , int i){
        int bitmask = -1<<i;  //-1 == 11111111111==~0
        return n&bitmask;
    }

    public static int clearRangeBit(int n , int i, int j){
        int a = -1<<j+1;
        int b = (1<<i)-1;
        int bitmask = a|b;
        return n &bitmask;
    }

    public static boolean check_power_of_two(int n ){
         return (n&(n-1))==0 ;
    }

    public static int CountSetBitNum(int n){
        int count = 0;
        while (n>0) {
            if ((n&1)!=0) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int FastExponential(int a , int n){
        int ans = 1;
        while (n>0) {
            if ((n&1)!=0) {
                ans = ans *a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Check_odd_even(6);
        // System.out.println(clearRangeBit(15,2,4));
        // System.out.println(CountSetBitNum(8));
        System.out.println(FastExponential(2, 10));
    }
}
