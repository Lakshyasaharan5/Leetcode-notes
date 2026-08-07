class MyHashSet {

    /**
        [0 1 2 3 4]

        0 : [] -> []....
        1 : [] -> []....
        2 :
        3 : 
        4 :  
     */
    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    private Node[] buckets;
    private int N;
    public MyHashSet() {
        N = 10000;
        buckets = new Node[N];
    }

    private int hash(int key) {
        return key % N;
    }
    
    public void add(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Node(key);
            return;
        }
        while (curr.next != null) {
            if (curr.value == key) return;
            curr = curr.next;
        }
        if (curr.value == key) return;
        curr.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) return;
        Node prev = null;
        while (curr != null && curr.value != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return;
        if (prev == null) {
            buckets[index] = curr.next;
            curr.next = null;
            return;
        }
        prev.next = curr.next;
        curr.next = null;        
        /**
            1 - 2 - 3
            p   c
         */
    }
    
    public boolean contains(int key) {
        Node curr = buckets[hash(key)];
        if (curr == null) return false;
        while (curr != null) {
            if (curr.value == key) return true;
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */