class ProductOfNumbers {
    /**
        0 1 2 3 4
        3 0 2 5 4

        a    b    c    d
        a   ab   abc  abcd
        0   1     2     3

        n-k-1
       

     */
    List<Integer> prefix;
    int lastIndexOfZero = -1;
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
    }
    
    public void add(int num) {    
        if (prefix.size() == 0) {
            prefix.add(num);
            if (num == 0) {
                lastIndexOfZero = prefix.size() - 1;
            }
            return;
        }        
        if (prefix.get(prefix.size() - 1) == 0) {
            prefix.add(num);
        } else {
            prefix.add(num * prefix.get(prefix.size() - 1));
        }
        if (num == 0) {
            lastIndexOfZero = prefix.size() - 1;
        }        
    }
    
    public int getProduct(int k) {
        int size = prefix.size();
        if (k == size) {
            if (lastIndexOfZero != -1) return 0;
            return prefix.get(size - 1);
        }
        if (lastIndexOfZero >= size - k) return 0;
        if (prefix.get(size - k - 1) == 0) return prefix.get(size - 1);
        return prefix.get(size - 1) / prefix.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */