class LogSystem {
    String min = "2000:01:01:00:00:00";
    String max = "2017:12:31:23:59:59";
    Map<String, Integer> map; // 力度 : 到哪为止的index
    TreeMap<String, LinkedList<Integer>> logs; // timeStamp: <ids>

    public LogSystem() {
        map = new HashMap<>();
        map.put("Year", 4); // 取前4
        map.put("Month", 7); // 取前7，然后贴上min 和 max的后面
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);

        logs = new TreeMap<>();
    }
    
    // Treemap time complexity: O(logN)
    public void put(int id, String timestamp) {
        if (!logs.containsKey(timestamp)) {
            logs.put(timestamp, new LinkedList<>());
        }

        // 同一个timestamp不重复添加id
        if (!logs.get(timestamp).contains(id)) logs.get(timestamp).add(id);
    }

    // Treemap time complexity: O(logN)
    public List<Integer> retrieve(String start, String end, String granularity) {
        int index = map.get(granularity); // 拿到力度对应的index（应该取到哪一位）
        String s = start.substring(0, index) + min.substring(index); // 补全
        String e = end.substring(0, index) + max.substring(index); // 补全

        List<Integer> res = new LinkedList<>();

        // subMap:最小的key，是否包括它，最大的key，是否包括它, time complexity: O(1)
        Map<String, LinkedList<Integer>> sub = logs.subMap(s, true, e, true);
        for (LinkedList<Integer> list: sub.values()) {
            res.addAll(list);
        }

        return res;
    }
}
