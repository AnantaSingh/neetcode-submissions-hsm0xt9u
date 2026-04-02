class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node left;   // dummy head
    private Node right;  // dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        remove(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.val = value;
            remove(node);
            insertAfterHead(node);
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);

        if (map.size() > capacity) {
            Node lru = right.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node node) {
        Node first = left.next;
        left.next = node;
        node.prev = left;
        node.next = first;
        first.prev = node;
    }
}