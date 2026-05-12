import java.util.*;

public class DequeOperations {
    public static void main(String[] args) {
        Deque <Integer> dq = new LinkedList<>();

        dq.addFirst(11);
        dq.addFirst(12);
        dq.addLast(34);
        dq.addLast(3);
        System.out.println(dq);
        dq.removeLast();
        dq.removeFirst();
        System.out.println(dq);
        System.out.println(dq.getFirst());
    }
}
