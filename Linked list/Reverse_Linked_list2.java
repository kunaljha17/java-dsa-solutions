// 1. Reach left using index.
// 2. Reverse until right.
// 3. Connect beforeLeft and afterRight.


//Approach 
//i create dummy node bcz first check from head node ...so
//dummy node point to head .
//then find left node before  by using loop 
// so on reverse after before leftnode then connect 




class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head ==null || head.next == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }
        ListNode leftNode = beforeLeft.next;  

        ListNode prev = null;
        ListNode curr = leftNode;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
         
        beforeLeft.next =prev;
        leftNode.next= curr;

        return dummy.next;
    }
}
