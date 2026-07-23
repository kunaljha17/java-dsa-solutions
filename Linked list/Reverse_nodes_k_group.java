// approach is: MUST REVISE PROBLEM

// Count the number of nodes.
// Compute how many complete groups of size k exist.
// Reverse exactly k nodes.
// Connect the reversed group to the previous and next parts.
// Repeat.


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp= temp.next;
            size++;
        }
        int noOfReverseOperation = size/k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        ListNode leftNode = beforeLeft.next;

        for(int i =0;i<noOfReverseOperation;i++){
            ListNode curr = leftNode;
            ListNode prev = null;
            ListNode next;
            int j =0;
            while(j<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                j++;
            }
            beforeLeft.next = prev;
            leftNode.next =curr;
            beforeLeft = leftNode;
            leftNode =  curr;
        }
        return dummy.next;
    }
}
