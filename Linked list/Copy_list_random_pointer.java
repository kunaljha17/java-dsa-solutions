  //Approach is we have to build full same structure everything but with diffrent memory means create new same with diffrent address


class Solution {
    private Map<Node,Node> visited = new HashMap<>();
    public Node deepCopy(Node head){

        if(head ==null) return null;

        if(visited.containsKey(head)) return visited.get(head);

        Node newNode = new Node(head.val);
        visited.put(head,newNode);
        newNode.next =  deepCopy(head.next);
        newNode.random = deepCopy(head.random);
        
        return newNode;
    }

    public Node copyRandomList(Node head) {
        return deepCopy(head);
        
    }
}
