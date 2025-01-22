class UndergroundSystem {
    // 记录某个路线的总 travel 时间和总 travel 人数
    Map<String, int[]> routeToSumAmount;
    // 记录某个人的入站点和入站时间
    Map<Integer, Pair<String, Integer>> idToStart;

    public UndergroundSystem() {
        routeToSumAmount = new HashMap<>();
        idToStart = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        // 记录当前 id 的乘客的入站点和入站时间
        idToStart.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // 找到当前 id 的乘客的入站点和入站时间
        Pair<String, Integer> pair = idToStart.get(id);
        String startStation = pair.getKey();
        int startTime = pair.getValue();

        // 入站 + 出站的路线
        String fullRoute = startStation + "->" + stationName;
        // 花费的时间
        int duration = t - startTime;

        // 如果这个路线是第一次出现，初始化记录这个路线的总 travel 时间和总 travel 人数
        if (!routeToSumAmount.containsKey(fullRoute)) {
            routeToSumAmount.put(fullRoute, new int[2]);
        }

        // 更新
        routeToSumAmount.get(fullRoute)[0] += duration;
        routeToSumAmount.get(fullRoute)[1]++;

        // 乘客出站以后记得移除
        idToStart.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String fullRoute = startStation + "->" + endStation;

        // 这个路线还没有乘客搭乘过，无记录
        if (!routeToSumAmount.containsKey(fullRoute)) return -1;

        // 返回结果
        return (double) routeToSumAmount.get(fullRoute)[0] / routeToSumAmount.get(fullRoute)[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */