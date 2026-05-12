import java.util.*;

public class StacktwoQue {

    public static class QuewithStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add
        public void push(int data) {// push element into the non-empty queue to maintain single active queue

            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // pop
        public int pop() {
            int pop = -1;// initialize variable to store popped value

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return pop;
            }
            if (!q1.isEmpty()) {//First queue is empty then,
                while (!q1.isEmpty()) {//Run loop until it get empty
                    pop = q1.remove();//pop and store val to pop
                    if (q1.isEmpty()) {//last val break here
                        break;
                    }
                    q2.add(pop);//still not empty then push to another queue
                }
            } else { //similarly
                while (!q2.isEmpty()) {
                    pop = q2.remove();
                    if (q2.isEmpty()) {// this is for prevent from storing stored value into new queue
                        break;
                    }
                    q1.add(pop);
                }
            }
            return pop;//return deleted value
        }

        public int peek() {//Similar to pop but here we store last queue also ..
            int pop = -1;
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return pop;
            }
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    pop = q1.remove();
                    q2.add(pop);
                }
            } else {
                while (!q2.isEmpty()) {
                    pop = q2.remove();
                    q1.add(pop);
                }
            }
            return pop;// return top value

        }

    }

    public static void main(String[] args) {

    }
}
