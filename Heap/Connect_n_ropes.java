import java.util.*;

public class Connect_n_ropes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ropes[] = {4,3,2,6};

        for(int i = 0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        
        while (pq.size()>1) {
             int min = pq.remove();
             int min2 = pq.remove();
             cost += min +min2;
             pq.add(min+min2);//again add both connected rope
        }
        System.out.println(cost +" ");
    }
}
