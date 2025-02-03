class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        int l=0, h=list.size()-1;
        while(l<h){
            int m = l + (h-l+1)/2;
            if(list.get(m).time == timestamp) 
                return list.get(m).val;
            if(list.get(m).time < timestamp)
                l=m;
            else
                h=m-1;                
        }
        return list.get(l).time <= timestamp ? list.get(l).val : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */