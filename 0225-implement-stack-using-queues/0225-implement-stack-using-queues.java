class MyStack {
    Queue<Integer> q1, q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        int size = q1.size();
        while (size-- > 1) {
            q2.offer(q1.poll());
        }
        int top = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return top;
    }
    
    public int top() {
        int size = q1.size();
        while (size-- > 1) {
            q2.offer(q1.poll());
        }
        int top = q1.peek();
        q2.offer(q1.poll());
        q1 = q2;
        q2 = new LinkedList<>();
        return top;
    }
    
    public boolean empty() {
        return q1.size() == 0;
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