class MyCircularQueue {
    int f = 0;
    int r = -1;
    int[] arr = null;
    int size = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        this.size++;
        this.r = (this.r + 1) % arr.length;
        arr[this.r] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) return false;
        this.size--;
        this.f = (this.f + 1) % arr.length;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) return -1;
        return this.arr[this.f];
    }
    
    public int Rear() {
        if (this.isEmpty()) return -1;
        return this.arr[this.r];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */