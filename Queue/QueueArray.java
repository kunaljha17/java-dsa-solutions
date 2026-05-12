public class QueueArray {

    static class Queuearr {

        int arr[];
        int size;
        int rear;

        Queuearr(int size) {
            arr = new int[size];
            this.size = size;
            rear = -1;
        }

        // isEmpty
        public boolean isEmpty() {
            return rear == -1;
        }

        // add
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full !!");
                return;
            }
            arr[++rear] = data;
        }

        // remove
        public int remove() {// *****O(n)******
            if (isEmpty()) {
                System.out.println("Queue is empty!!");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!!");
                return -1;
            }
            return arr[0];

        }

    }

    public static void main(String[] args) {
        Queuearr q = new Queuearr(3);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}