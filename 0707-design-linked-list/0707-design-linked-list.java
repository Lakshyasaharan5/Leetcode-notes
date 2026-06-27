class MyLinkedList {
    private int size = 0;
    class Node {
        int val;
        Node next;
        Node prev;
        Node(int v) {
            this.val = v;
            next = null;
            prev = null;
        }
    }
    Node head;
    Node tail;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return - 1;
        // traverse and return
        int i = 0;
        Node curr = head.next;
        while (i != index) {
            i++;
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node node = new Node(val);
        if (index == 0) {
            // add after head
            Node t = head.next;
            head.next = node;
            node.prev = head;
            node.next = t;
            t.prev = node;
            size++;
            return;
        }
        if (index == size) {
            // add before tail
            Node t = tail.prev;
            tail.prev = node;
            node.next = tail;
            t.next = node;
            node.prev = t;
            size++;
            return;
        }
        //traverse and insert
        int i = 0;
        Node curr = head.next;
        while (i != index) {
            i++;
            curr = curr.next;
        }
        Node t = curr.prev;
        curr.prev = node;
        node.next = curr;
        t.next = node;
        node.prev = t;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        // traverse and delete
        int i = 0;
        Node curr = head.next;
        while (i != index) {
            i++;
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */