import java.util.*;

public class StackQestions {

    // static Stack<Integer> s = new Stack<>();
    public static void BottomPush(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int val = s.pop();
        BottomPush(s, data);
        s.push(val);
    }

    // Q2
    public static String ReverseStr(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch);
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char ch = s.pop();
            result.append(ch);
        }
        return result.toString();
    }

    // Q3(Reverse a stack )
    public static void ReverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        ReverseStack(s);
        BottomPush(s, top);
    }

    // Q4
    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        
        for(int i =1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while (!s.isEmpty()&&currPrice>=stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i]= i-prevHigh;
            }
            s.push(i);
        }
    }

    //Q5
    public static void NextGreater(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nextG[] = new int[arr.length];
        for(int i = arr.length-1; i>=0;i--){
            while (!s.isEmpty()&& arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextG[i] = -1;
            }else{
                nextG[i] =arr[s.peek()];
            }
            s.push(i);
        }
        for(int i =0;i<nextG.length;i++){
            System.out.print(nextG[i]+" ");
        }
        System.out.println();
        
    }

    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        




        s.push(1);
        s.push(2);
        s.push(3);
        BottomPush(s, 4);
        // without rev output -> 3-2-1
        // with reverse output ->1-2-3
        // ReverseStack(s);
        while (!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
        }

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for (int i = 0; i < span.length; i++) {
        //     System.out.print(span[i] + " ");
        // }


        // <<<---->>>
        // int arr []= {6,8,0,1,3};
        // NextGreater(arr);//Done

        //next Greater Right
        //next Greater Left
        //next Smaller Right
        //next Smaller Left
    }
}
