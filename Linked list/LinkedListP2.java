import java.util.*;

public class LinkedListP2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public boolean IsCycleDet() {// Floyd's CFA

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
            if (slow == fast) {
                return true;// cycle exists.?
            }
        }
        return false;

    }

    public void RemoveCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while (slow != fast) {// 2nd time when both meet At Node
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }
        prev.next = null;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node rightNode = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);// left half
        Node newRight = mergeSort(rightNode);// Right half
        return merge(newLeft, newRight);

    }

    public Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1!=null&&head2!=null) {
            if (head1.data<head2.data) {
                temp.next=head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1!=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;

    }


    public void ZigZagLL(){
        Node mid = findMid(head);
        
        // Reverse 2nd half 
        Node Curr = mid.next;
        Node prev = null;
        Node next ;
        while (Curr!=null) {
            next = Curr.next;
            Curr.next = prev;
            prev=Curr;
            Curr = next;
        }
        Node Rh = prev;
        mid.next = null;
        Node Lh= head;
        Node nextL,nextR;
        while (Rh!=null) {
             nextL = Lh.next;
             Lh.next=Rh;
             nextR =Rh.next;
             Rh.next=nextL;
             Lh = nextL;
             Rh = nextR;
        }
    }


    public static void main(String[] args) {
        LinkedListP2 ll = new LinkedListP2();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        System.out.println(ll.IsCycleDet());
        ll.RemoveCycle();
        System.out.println(ll.IsCycleDet());

    }

}
