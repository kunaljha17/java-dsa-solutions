// Replace its value with the next node's value.
// Remove the next node from the chain by changing the pointer.


class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; //Copy
        node.next = node.next.next; //Change pointer
        
    }
}
