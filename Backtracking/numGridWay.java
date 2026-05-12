public class numGridWay {

    public static int totalGridway(int i , int j , int m , int n ){
        if (i ==m-1&&j==n-1) {//condn for last cell 
            return 1;
        }
        else if (i==m||j==n) {
            return 0;
        }
        //down
        int w1 = totalGridway(i+1, j, m, n);
        //right
        int w2 = totalGridway(i, j+1, m, n);
        return w1 +w2;
    }

    public static void main(String[] args) {
        // System.out.println(totalGridway(0, 0, 4, 4));
        
    }
}
