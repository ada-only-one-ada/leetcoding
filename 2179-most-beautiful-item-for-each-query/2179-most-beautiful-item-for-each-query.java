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
        // 因为price在一开始按从小到大排序了，所以在这之前的item，价格肯定是低于或者等于的，它们的beuty如果更大可以适用当前item
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
        }

        return res;
    }
}