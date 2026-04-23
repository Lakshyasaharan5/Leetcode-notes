class Node {
    String url;
    Node prev;
    Node next;
    public Node (String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node head, curr;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        curr.next = new Node(url);
        curr.next.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && curr.prev != null) {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */