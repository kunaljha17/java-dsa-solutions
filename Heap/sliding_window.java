import java.util.PriorityQueue;

public class sliding_window {

    static class SW implements Comparable<SW>{//pair object
        int num;
        int idx;
        public SW(int num , int idx){
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(SW s2){
            return s2.num - this.num;//descending priority queue
        }
    }


    public static void main(String[] args) {
        PriorityQueue<SW> pq = new PriorityQueue<>();//O(nlogk)
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;//size of sliding window
        int window[] = new int[arr.length-k+1];//result array
        for(int i = 0;i<k;i++){//adding element in priority queue
            pq.add(new SW(arr[i], i));
        }
        window[0] = pq.peek().num;//first element is max becz descending priority queue prop..
        for(int i = k;i<arr.length;i++){
            while (pq.peek().idx<=(i-k)) {//check does front element is lie in required index or not 
                pq.remove();
            }
            pq.add(new SW(arr[i], i));//adding new object
            window[i-k+1] = pq.peek().num;// storing 
        }

        //print result
        for(int i = 0;i<window.length;i++){
            System.out.print(window[i]+" ");
        }
        System.out.println();
    }
}
