import java.util.*;

public class QueueUsingDeque {

    

    static class Queue {
        Deque<Integer> dq = new LinkedList<>();
        //is empty
        public boolean isEmpty(){
            return dq.size() == 0;
        }
        //add
        public void add(int data){
            dq.addLast(data);
        }
        //remove
        public int remove(){
            return dq.removeFirst();
        }
        //peek
        public int peek(){
            return dq.getFirst();
        }
        
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(9);
        q.add(10);
        while (!q.isEmpty()) {
            System.out.print(q.remove()+ " ");
        }
    }
}
