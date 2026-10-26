//Reverse
//Add carry = 1 and at the end i will check that too that we have still carry then make new Node to add at the end 
//Reverse again 
//Once silly thing that node value can reassign directly


class Solution {
	
	public Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public Node addOne(Node head) {
		Node RevHead = reverse(head);
		Node temp = RevHead;
		int carry = 1;
		while (temp != null) {
			int val = temp.data + carry;
			carry = val/10;
			temp.data = val % 10;
			if (carry == 0)
				break;
			if (temp.next == null && carry != 0) {
				temp.next = new Node(carry);
				carry = 0;
			}
			temp = temp.next;
		}
		
		return reverse(RevHead);
	}
}
