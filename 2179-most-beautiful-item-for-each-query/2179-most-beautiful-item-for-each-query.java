class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) { // same price，higher beauty first
                return b[1] - a[1];
            };
            return a[0] - b[0]; // lower price first
        });

        TreeMap<Integer, Integer> map = new TreeMap<>(); // price to beauty
        int maxBeautySoFar = 0;
        for (int i = 0; i < items.length; i++) {
            int price = items[i][0];
            int beauty = items[i][1];

            // 因为price在一开始按从小到大排序了，所以在这之前的item，
            // 价格肯定是低于或者等于的，它们的beuty如果更大可以适用当前item
            maxBeautySoFar = Math.max(beauty, maxBeautySoFar);
            map.put(price, maxBeautySoFar);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer last = map.floorKey(queries[i]);

            if (last == null) continue;
            res[i] = map.get(last);
        }

        return res;
    }
}