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