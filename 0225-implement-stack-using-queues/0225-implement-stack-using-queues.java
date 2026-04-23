class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int size = q.size();
        while (size-- > 1) {
            q.offer(q.poll());
        }
        int top = q.poll();
        return top;
    }
    
    public int top() {
        int size = q.size();
        while (size-- > 1) {
            q.offer(q.poll());
        }
        int top = q.poll();
        q.offer(top);
        return top;
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */