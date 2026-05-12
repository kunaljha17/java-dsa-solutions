public class StackArray {

        private int arr[];
        private int capacity;
        private int top;

        StackArray(int size) {
            capacity = size;
            arr = new int[capacity];
            top = -1;
        }

        // push
        public void push(int data) {
            if (isfull()) {
                System.out.println("Stack is full!");
                return;
            }
            arr[++top] = data;
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return arr[top--];
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isfull() {
            return top == capacity - 1;
        }
    

    public static void main(String[] args) {
        StackArray s = new StackArray(10);
        s.push(11);
        s.push(13);
        s.push(16);
        s.push(161);
        s.push(15);
        s.push(19);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
