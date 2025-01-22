class UndergroundSystem {
    Map<String, int[]> locsToSumAmount;
    Map<Integer, Pair<String, Integer>> idToLocs;

    public UndergroundSystem() {
        locsToSumAmount = new HashMap<>();
        idToLocs = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToLocs.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = idToLocs.get(id);
        String startLoc = pair.getKey();
        int startTime = pair.getValue();

        String fullRoute = startLoc + "->" + stationName;
        int duration = t - startTime;

        if (!locsToSumAmount.containsKey(fullRoute)) {
            locsToSumAmount.put(fullRoute, new int[2]);
        }

        locsToSumAmount.get(fullRoute)[0] += duration;
        locsToSumAmount.get(fullRoute)[1]++;

        idToLocs.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String fullRoute = startStation + "->" + endStation;

        if (!locsToSumAmount.containsKey(fullRoute)) return -1;

        return (double) locsToSumAmount.get(fullRoute)[0] / locsToSumAmount.get(fullRoute)[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */