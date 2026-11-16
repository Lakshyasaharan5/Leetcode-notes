class OrderedStream {
    /**
        
        0   1    2    3 
           zzz   aa   cc
        2,aa
        1,zzz
        3,cc

        2 : aa
        1 : zzz
        3 : cc
        7 : dd
        5 : rr
        4 : uu

        ptr = 6

     */
    String[] arr;
    int ptr = 1;
    public OrderedStream(int n) {
        arr = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> curr = new ArrayList<>();
        while (ptr < arr.length && arr[ptr] != null) {
            curr.add(arr[ptr]);
            ptr++;
        }
        return curr;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */