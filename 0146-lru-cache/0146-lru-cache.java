class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node); // update of its position in the linkedlist
        add(node);    // update of its position in the linkedlist

        return node.value;
    }

    public void add(Node node) {
        // empty list
        if (head == null) {
            head = node;
            tail = node;
            tail.next = null;
        // add to the end of the linkedlist
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
            tail.next = null;
        }
    }

    public void remove(Node node) {
        // in the middle
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        // head node
        } else if (node.prev == null && node.next != null) {
            head = head.next;
            head.prev = null;
        // tail node
        } else if (node.prev != null && node.next == null) {
            tail = tail.prev;
            tail.next = null;
        // single node
        } else {
            head = null;
            tail = null;
        }
    }
    
    public void put(int key, int value) {
        // have the key 
        if (get(key) != -1) { // calling get() will update the position
            Node node = map.get(key);
            node.value = value;
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                remove(head);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }
}

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
} 