class Solution {
    public Node deleteAllOccurOfX(Node head, int x) {
        
        Node temp = head;
        
        while(temp != null){
            if(temp.data == x){
                if(head == temp){
                    head = head.next;
                }
                if(temp.prev != null){
                    temp.prev.next = temp.next;
                }
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}


