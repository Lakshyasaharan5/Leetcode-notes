class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node (int k, int v) {
        key = k;
        val = v;
        next = null;
        prev = null;
    }
}
class LRUCache {

    private Node head, tail;
    private HashMap<Integer, Node> mpp;
    private int size;
    private int capacity;    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        mpp = new HashMap<>();
    }
    
    private void insertAtEnd(Node node) {
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;
    }

    private Node removeNode(Node node) {
        if (node == null)
            node = head.next;
        if (node.next == null) return node;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    public int get(int key) {
        if (!mpp.containsKey(key)) return -1;
        Node node = mpp.get(key);
        insertAtEnd(removeNode(node));
        return node.val;
    }    
    // h-[2,2]-[3,3]-t    map {key: node}   
    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            mpp.get(key).val = value;
            insertAtEnd(removeNode(mpp.get(key)));
            return;
        }
        Node newNode = new Node(key, value);
        if (this.size == this.capacity) {
            Node removedNode = removeNode(null);
            mpp.remove(removedNode.key);
            this.size--;
        }        
        insertAtEnd(newNode);
        mpp.put(key, newNode);
        this.size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */