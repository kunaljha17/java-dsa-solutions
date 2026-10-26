class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
         
        int size = 0;
        ListNode temp = head;
        while(temp!= null){
            size++;
            temp = temp.next;
        }
        int pos = size - n;
        if (pos == 0) {
            return head.next;
        }

        ListNode prevTemp = head;
        for(int i = 0;i<pos-1;i++){
            prevTemp = prevTemp.next;
        }
         
        prevTemp.next = prevTemp.next.next;
        return head;
    }
}
