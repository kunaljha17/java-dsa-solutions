import java.util.*;
public class StackusingDeque {

    static class Stack {
        Deque <Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
           return dq.size() ==0;
        }
        //push
        public void push(int data){
            dq.addLast(data);
        }
        //pop
        public int pop(){
            return dq.removeLast();
        }
        //peek
        public int peek(){
            return dq.getLast();
        }
        
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(8);
        s.push(10);
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        
    }
}
