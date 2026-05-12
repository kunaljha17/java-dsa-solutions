import java.util.*;

public class QueTwoStack {

    public static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        // add
        public void add(int data) {

            while (!s1.isEmpty()) {//Move all elements from s1 → s2
                s2.push(s1.pop());
            }

            s1.push(data);//Push new element into s1

            while (!s2.isEmpty()) {//Move everything back from s2 → s1
                s1.push(s2.pop());
            }
        }

        //Front of queue is always at the top of s1
        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!!");
                return -1;
            }
           return s1.pop();
        }
        //peek
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return s1.peek();
        }

    }

    public static void main(String[] args) {

    }
}
