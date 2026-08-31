//Mainly we have to allocate new memory location to node 
//so here for visited we use Hashmap 


class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val);
        visited.put(node, clone);  

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
