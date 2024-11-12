class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            return a[0] - b[0];
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items.length; i++) {
            int price = items[i][0];
            int beauty = items[i][1];
            int prevBeauty = map.containsKey(price) ? map.get(price) : 0;
            map.put(price, Math.max(beauty, prevBeauty));
        }

        int maxBeauty = 0;
        for (int price: map.keySet()) {
            maxBeauty = Math.max(maxBeauty, map.get(price));
            map.put(price, maxBeauty);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ts = queries[i]; 

            if (map.floorKey(ts) != null) {
                res[i] = map.get(map.floorKey(ts));
            } 
            
            if (map.lowerKey(ts) != null) {
                res[i] = Math.max(res[i], map.get(map.lowerKey(ts)));
            } 
        }

        return res;
    }
}