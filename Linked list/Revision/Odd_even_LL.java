//Here we doing by Optimal way , O(1) space and O(N) time 

//just moving pointer make our desire linkedlist then at the end we connect to make one full linked list

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode odd = head;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
