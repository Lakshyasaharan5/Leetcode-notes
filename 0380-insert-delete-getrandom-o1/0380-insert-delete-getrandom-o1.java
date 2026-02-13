class RandomizedSet {
    HashMap<Integer, Integer> index;
    ArrayList<Integer> list;
    Random rand;

    public RandomizedSet() {
        index = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();        
    }
    
    public boolean insert(int val) {
        if (index.containsKey(val)) return false;
        index.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        int i = index.get(val);
        if (i != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(i, last);
            index.put(last, i);
        }
        list.remove(list.size() - 1);
        index.remove(val);
        return true;
    }
    
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */