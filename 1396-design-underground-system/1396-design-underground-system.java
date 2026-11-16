class UndergroundSystem {

    /**
        45 l t1
        45 w t2

        78 l t4
        78 y t5

        62 l t6
        62 w t8

        45 -> [start station, start time]

        l-w -> [total time, number of customers]

    
     */
    Map<Integer, Pair<String, Integer>> idToStartStation;
    Map<String, Pair<Integer, Integer>> startEndStationToTime;

    public UndergroundSystem() {
        idToStartStation = new HashMap<>();
        startEndStationToTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToStartStation.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startStation = idToStartStation.get(id).getKey();
        int startTime = idToStartStation.get(id).getValue();
        String key = startStation + "-" + stationName;
        startEndStationToTime.compute(key, (k, v) -> {
            if (v == null) {
                v = new Pair<>(t - startTime, 1);
            } else {
                v = new Pair<>(v.getKey() + t - startTime, v.getValue() + 1);
            }         
            return v;   
        });
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> p = startEndStationToTime.get(startStation + "-" + endStation);
        // System.out.println(p.getKey());
        // System.out.println(p.getValue());
        return (double)p.getKey() / (double)p.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */