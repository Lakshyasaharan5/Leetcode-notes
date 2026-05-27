class StockSpanner {
    List<Integer> prices = null;
    Stack<Integer> st = null;
    int index;
    public StockSpanner() {
        prices = new ArrayList<>();
        st = new Stack<>();        
        index = -1;
    }
    
    public int next(int price) {
        index++;
        prices.add(price);                
        while (!st.isEmpty() && prices.get(st.peek()) <= price) 
            st.pop();    
        int res = 0;    
        if (st.isEmpty()) {                        
            res = index + 1;
        } else        
            res = index - st.peek();
        st.push(index);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */