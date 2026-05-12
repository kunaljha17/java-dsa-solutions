public class RecusionP1 {

    public static void printDec(int n) {

        if (n == 1) {// base call
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");

    }

    public static int NthSum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + NthSum(n - 1);
        return sum;
    }

    public static int FibNth(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fbnm1 = FibNth(n - 1);
        int fbnm2 = FibNth(n - 2);
        int fb = fbnm1 + fbnm2;
        return fb;
    }

    public static boolean SortedOrNot(int arr[], int i) {

        if (i == arr.length) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return SortedOrNot(arr, i + 1);

    }

    public static int FirstOcur(int arr[], int key, int i) {

        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return FirstOcur(arr, key, i + 1);

    }

    public static int lastOcur(int arr[], int key, int i) {
       
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOcur(arr, key, i + 1);

        // if found in right side, return it
        if (isFound != -1) {
            return isFound;
        }

        // otherwise check current element
        if (arr[i] == key) {
            return i;
        }

        return isFound;

    }

    public static int powerBrute(int x , int n){
        if (n==1) {
            return x;
        }
        int ans = x * powerBrute(x, n-1);
        return ans;
    }

    public static int powerOptimize(int n , int x){
        if (x == 0) {
            return 1;
        }
        int halfPower = powerOptimize(n, x/2);
        int halfPowerSq =  halfPower*halfPower;

        if (x%2!=0) {
           return n * halfPowerSq; 
        }
        return halfPowerSq;
    }



    public static void main(String[] args) {
        int n = 10;
        // printInc(n);
        // System.out.println(NthSum(n));
        // System.out.println(FibNth(6));

        // int arr[] = { 45, 64, 23, 64, 34, 23, 54 };
        // System.out.println(FirstOcur(arr, 23, 0));

        System.out.println(powerOptimize(2, 8));
    }
}
