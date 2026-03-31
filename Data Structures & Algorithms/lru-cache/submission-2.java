class ListNode { // ListNode class 
    int val;
    int key;
    ListNode prev;
    ListNode next;

    public ListNode(int val, int key)
    {
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode left; // head
    ListNode right; // tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);

        this.left.next = this.right; 
        this.right.prev = this.left;

        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        //check in hashmap if present get the Node value
        //once get done delete from LinkedList
        //insert to front of list
        //if not present return -1

        int value = -1;

        if(map.containsKey(key)){ //containsKey
            ListNode node = map.get(key);
            value = node.val;
            deleteNode(node);
            insertAfterHead(node);
        }

        return value;      
    }
    
    public void put(int key, int value) {
        // if present in map delete from LinkedList
        //create New Node , add to map
        //insert to front of list
        if(map.containsKey(key))
        {
            deleteNode(map.get(key));
        }

        ListNode node = new ListNode(value, key);
        map.put(key, node);
        insertAfterHead(node);

        if(map.size() > capacity)
        {
            ListNode del = this.right.prev;
            deleteNode(del);
            map.remove(del.key); // map fucntion
        }

        
    }

    public void deleteNode(ListNode node)
    {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertAfterHead(ListNode node)
    {
        ListNode currHead = this.left.next; // this rem
        this.left.next = node;
        node.next = currHead;
        currHead.prev = node;
       
        node.prev = this.left; 
    }
}
