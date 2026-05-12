public class Full_linked_listP1 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void add(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;// Tail is just a tracker of the last node.
        tail = newNode;
    }

    public void addMiddle(int i, int data) {
        Node newNode = new Node(data);
        if (i == 0) {
            add(data);
            return;
        }
        size++;
        Node temp = head;
        for (int j = 0; j < i - 1; j++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void printLL() {// head and tail store references (addresses) of nodes, not indexes
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int RemoveFirst() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int RemoveLast() {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int IterativeSearch(int key) {// O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int Searched(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int idx = Searched(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int RecursiveSearch(int key) {
        return Searched(head, key);
    }

    public void ReverseLL() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node prev = null;
        Node Curr = head;
        Node next;
        while (Curr != null) {
            next = Curr.next;
            Curr.next = prev;
            prev = Curr;
            Curr = next;
        }
        head = prev;
    }

    public void findAndRemNthLast(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;
            return;
        }
        Node prevNode = head; // Here i use i =1 because talk about position So when from last n =2 then from
                              // starting position is at i = 4 So i have to move preNode to i =3 position , so
                              // want loop runs only 2
        for (int i = 1; i < sz - n; i++) {// sz-n+1 position from starting So , when i want to remove node then i had to
                                          // get to one before node .
            prevNode = prevNode.next;
        }
        prevNode.next = prevNode.next.next;
        return;
    }

    public Node findMidNode(Node head){
        Node slow = head;//(+1)
        Node fast = head;//(+2)
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;//Here return a node refrence where mid is 
    }
    public boolean isPalindromeLL(){
        if (head ==null||head.next==null) {// Checking ll is empty or single element
            return true;
        }
        Node mid = findMidNode(head);

        Node prev = null;
        Node Curr = mid.next;//  skip middle for odd, safe for even!! so for both use mid.next . But also work with mid only.
        Node next;
        while (Curr!=null) {
            next = Curr.next;
            Curr.next = prev;
            prev = Curr;
            Curr = next;
        }
        Node right = prev;//Here , When reverse so, for tracking ll i give refrence to 2nd half first element to right 
        Node left = head;// another 1st half i give left 

        while (right!=null) {//until right is null because both even num or odd size ll common right is null when i want stop loop
            if (left.data != right.data) {//if not equal then return false
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }


    
    public static void main(String[] args) {
        Full_linked_listP1 ll = new Full_linked_listP1();
        ll.add(2);
        ll.add(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addMiddle(2, 9);
        ll.printLL();
        System.out.println("First removed ele " + ll.RemoveFirst());
        ll.printLL();
        System.out.println("last removed ele " + ll.RemoveLast());
        ll.printLL();
        System.out.println(size);
    }
}