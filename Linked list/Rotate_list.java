//Approach 1 this approach is not so effiecnt but first i code this ...
//size nikle then 
//no of rotation agr size se jada hai toh mdulo nikal ke pata kiya kitna bar actual rotate krna hai ...
// loop lagaye uske baad find kiya before last and last node.. then rotate ..
//This way is so inefficient 

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        k = k%size;
        for(int i = 0 ;i<k;i++){
          ListNode beforeLast = head;
          ListNode lastNode;
            for(int j = 1;j<size-1;j++){
                 beforeLast = beforeLast.next;
               }
         lastNode = beforeLast.next;
         lastNode.next = head;
         beforeLast.next = null;
         head = lastNode;
    }
    return head;
   }
}



//Approch two is more effficient and good ..

// Appraoch is :
// Find the length.
// Do k = k % length.
// Connect the tail back to the head to form a cycle.
// Find the new tail at position length - k - 1.
// Break the cycle.

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        size++;
        k = k%size;
        if (k == 0) return head;
        temp.next = head;
        ListNode newTail = head;
        for(int i =0;i<size-k-1;i++){
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null;
        return head;
   }
}
