import java.util.*;

public class nearbyCar {

    static class point implements Comparable<point> {
    int x;
    int y;
    int dist;
    int idx;
    public point(int x, int y, int dist, int idx) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.idx = idx;
    }
    @Override
    public int compareTo(point p2){
        return this.dist - p2.dist;
    }
    }
    public static void main(String[] args) {
        PriorityQueue<point> pq = new PriorityQueue<>();
        int arr[][] ={{3,3},{5,-1},{-2,4}};
        int k =2;
        for(int i =0;i<arr.length;i++){
            int dist =arr[i][0]*arr[i][0] +arr[i][1]*arr[i][1];
                pq.add(new point(arr[i][0], arr[i][1],  dist ,i));
        }

        while (k>0) {
            System.out.print("C"+pq.remove().idx +" ,");
            k--;
        }
        
    }
}
