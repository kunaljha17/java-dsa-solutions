 

public class StackLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        static Node head;

        public boolean isEmpty() {
            return head == null;
        }

        // push
        public void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty !");
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(11);
        s.push(1);
        s.push(13);
        s.push(18);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
