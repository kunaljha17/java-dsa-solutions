public class QueueLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLinkedList {
          Node head = null;
          Node tail = null; //Using static for head and tail makes all queue objects share the same memory, which breaks encapsulation and object independence.

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public void add(int data) {
            Node newNode = new Node(data);
            if (head ==null) {//First element
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already empty!");
                return -1;
            }
            int val = head.data;
            if (head == tail) {//single element
                tail = head = null;
            }
            else{
                head = head.next;
            }
            return val;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {

    }
}
