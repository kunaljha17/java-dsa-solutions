import java.util.*;

public class InterleaveTwoHalf {

    public static void ZigZagtype(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> Firsthalf = new LinkedList<>();
        for(int i=0;i<size/2;i++){
            Firsthalf.add(q.remove());//add in another new queue .half of original queue
        }
        while (!Firsthalf.isEmpty()) {
            q.add(Firsthalf.remove());//mix first add from new half queue
            q.add(q.remove());//then add from original queue . by rear of the original queue
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        ZigZagtype(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
