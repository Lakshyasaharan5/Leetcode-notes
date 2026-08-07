class FreqStack {
    /**          
        build from start
            st = [5,7,5,3,7]
        helper = 
        {
            2 : [5,7]
            1 : [5,7,3]
        }
        
     */
    private int maxFreq;
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> helper;
    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        helper = new HashMap<>();
    }
    
    public void push(int val) {
        if (!freq.containsKey(val)) {
            freq.put(val, 0);
        }
        freq.put(val, freq.get(val) + 1);
        int currFreq = freq.get(val);
        helper.compute(currFreq, (k, v) -> {
            if (v == null) v = new Stack<>();
            v.push(val);
            return v;
        });
        maxFreq = Math.max(maxFreq, currFreq);
    }
    
    public int pop() {
        Stack<Integer> mostFreqStack = helper.get(maxFreq);
        int element = mostFreqStack.pop();
        if (mostFreqStack.isEmpty()) maxFreq--;
        freq.put(element, freq.get(element) - 1);
        return element;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */