class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = null;
        tail = null;   
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
        } else {
            if (size == capacity) {
                map.remove(head.key);
                remove(head);
                size--;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
            size++;
        }
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.next = null;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
            tail.next = null;
        }
    }

    public void remove(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else if (node.next != null && node.prev == null) {
            head = node.next;
            node.next.prev = null;
        } else if (node.prev != null && node.next == null) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            head = null;
            tail = null;
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