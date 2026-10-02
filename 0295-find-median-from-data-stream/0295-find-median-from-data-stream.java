class MedianFinder {

    /**
        [1,2,3,9,10]  
        1,9,10,3,2,11
        max heap = [1,2]
        min heap = [10,9,3]

        if maxHeap empty:
            push
        else:
            if curr < maxHeap.top
                maxHeap.push
            else
                minHeap.push

        if len minHeap > maxH:
            move minH top to maxH
        if len(minHeap) - maxH > 1:
            move minH to max
          
    */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
        return (double)maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */