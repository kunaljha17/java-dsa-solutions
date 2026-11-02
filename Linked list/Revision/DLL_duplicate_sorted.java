class Solution {
    Node removeDuplicates(Node headRef) {
        if(headRef == null) return null;
         Node temp = headRef.next;
         Node prevNode = headRef;
         
         while(temp !=null){
            if(temp.data == prevNode.data){
                temp.prev.next = temp.next;
                if(temp.next !=null){
                    temp.next.prev = prevNode;
                }
                temp = temp.next;
            }else{
                prevNode = temp;
                temp= temp.next;
            }
         }
         return headRef;
    }
}
