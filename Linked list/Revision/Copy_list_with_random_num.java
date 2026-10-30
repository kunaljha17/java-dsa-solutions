//This approach is very nice and optimal  for this problem , 
//I can also done this with using hashmap store original node as key and create copy node there, and then connect them to form this deepcopy



//Approch 1 with hashmap
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);

            current = current.next;
        }
        return nodeMap.get(head);
    }
}



//Approach 2 with 
// 1 insert 
// 2 connect random node
// 3 regain and form final linkedlist

class Solution {
    // Function to clone the linked list using node interleaving.
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        // Insert a cloned node immediately after each original node.
        // This places every clone next to its corresponding original node.
        while (current != null) {
            Node clonedNode = new Node(current.data);

            clonedNode.next = current.next;
            current.next = clonedNode;

            current = clonedNode.next;
        }

        current = head;

        // Set the random pointer of each cloned node.
        // The clone of current.random is located immediately after current.random.
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        current = head;
        Node clonedHead = head.next;

        // Separate the interleaved nodes into the original and cloned lists.
        while (current != null) {
            Node clonedNode = current.next;

            // Restore the original node's next pointer.
            current.next = clonedNode.next;

            // Connect the cloned node to the next cloned node.
            if (clonedNode.next != null) {
                clonedNode.next = clonedNode.next.next;
            }

            current = current.next;
        }

        return clonedHead;
    }
}
