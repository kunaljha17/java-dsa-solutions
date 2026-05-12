import java.util.LinkedList;

class MyHashMap<K, V> {

    // Node class to store key-value pair
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // number of key-value pairs
    private int capacity = 16; // default bucket size
    private LinkedList<Node>[] buckets;

    // Constructor
    public MyHashMap() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Put (insert/update)
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // update
                return;
            }
        }

        bucket.add(new Node(key, value));
        size++;
    }

    // Get value
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    // Remove key
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        Node toRemove = null;
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    // Size
    public int size() {
        return size;
    }
   
}