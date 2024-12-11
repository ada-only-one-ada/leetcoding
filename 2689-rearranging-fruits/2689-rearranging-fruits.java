class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        if (basket1.length != basket2.length) return -1;
        int n = basket1.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++) {
            int fruit1 = basket1[i], fruit2 = basket2[i];
            map.put(fruit1, map.getOrDefault(fruit1, 0) + 1);
            map.put(fruit2, map.getOrDefault(fruit2, 0) - 1);

            min = Math.min(min, Math.min(fruit1, fruit2));
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int fruit: map.keySet()) {
            if (map.get(fruit) == 0) continue;
            if (map.get(fruit) % 2 != 0) return -1; 

            if (map.get(fruit) < 0) {
                int moveToBasket1 = Math.abs(map.get(fruit)) / 2;
                for (int i = 0; i < moveToBasket1; i++) {
                    list2.add(fruit);
                }
            } else {
                int moveToBasket2 = map.get(fruit) / 2;
                for (int i = 0; i < moveToBasket2; i++) {
                    list1.add(fruit);
                }
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        long cost = 0;
        int i1 = 0, j1 = list1.size() - 1, i2 = 0, j2 = list2.size() - 1;

        while (i1 <= j1 && i2 <= j2) {
            if (list1.get(i1) <= list2.get(i2)) {
              
                cost += Math.min(2 * min, list1.get(i1));
                i1++;
                j2--;
            } else {
                cost += Math.min(2 * min, list2.get(i2));
                i2++;
                j1--;
            }
        }

        return cost;
    }
}