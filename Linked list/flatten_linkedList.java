// Approach *******
// Save next.
// Flatten the child.
// Connect parent → child.
// Remove child.
// Find child's tail.
// Connect tail → saved next.
// Continue traversal.
// *****

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
 //jb child nhi hai tb sirf curr ka pointer inc krna hai ... jaise curr ke pass child hoga then us child parent banake usme curr ko inc krna hai aur usme head return krna hai jo ham 
//prev parent jaha curr ko child mila usme next se point kr denge aur prev bhi krenge curr ko ..child ko null ... so on 
    public Node flatten(Node head) {
        if(head ==null) return head;
         Node curr = head;

         while(curr !=null){
            if(curr.child != null){ //child hai
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;
                while(curr.next!=null){
                    curr = curr.next;
                }
                if(next !=null){
                curr.next = next;
                curr.next.prev = curr;
                }
            }
             curr = curr.next;  //child nhi hai
         }
         return head;
    }
