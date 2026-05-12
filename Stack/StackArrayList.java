import java.util.ArrayList;

public class StackArrayList {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    // push
    public void push(int data) {
        list.add(data);
    }

    // pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return val;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {

    }
}
