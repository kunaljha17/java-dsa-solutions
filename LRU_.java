// here i use HashMap to acces node wioth O(1) time 
//double linkedlist use here for track LRU element 
//First make node obj
//initialize LRU with constructor
//then first write logic of put 
//then write get logic 
//Use linkedlist helper function





class LRUCache {
    static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
     Node head;
      Node tail;
      Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
        return -1;
    }
    Node node = map.get(key);
    moveToHead(node);
    return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node newNode = map.get(key);
            newNode.value = value;
            moveToHead(newNode);
        }else{
            if(map.size() == capacity){
                Node LruNode = removeTailPrev();
                map.remove(LruNode.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addToHead(newNode);
        }
        
    }

    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToHead(Node node){
         removeNode(node);
         addToHead(node);
    }
    private Node removeTailPrev(){
        Node lruNode = tail.prev;
        removeNode(tail.prev);
        return lruNode;
    }
}
