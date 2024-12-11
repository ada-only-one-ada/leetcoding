class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        if (basket1.length != basket2.length) return -1;
        int n = basket1.length;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE; // 工具瓜

        for (int i = 0; i < n; i++) {
            int fruit1 = basket1[i];
            int fruit2 = basket2[i];

            // 两个篮子都有的，value 为 0
            // 只有 basket1 才有的，value 为 正数
            // 只有 basket2 才有的，value 为 负数
            map.put(fruit1, map.getOrDefault(fruit1, 0) + 1);
            map.put(fruit2, map.getOrDefault(fruit2, 0) - 1);

            min = Math.min(min, Math.min(fruit1, fruit2));
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int fruit: map.keySet()) {
            if (map.get(fruit) == 0) continue; // 两篮都有，不需要交换
            if (map.get(fruit) % 2 != 0) return -1; // 只有一个篮子有，但是是单数，不能等分成两半，返回 -1

            // 只有 basket2 才有
            if (map.get(fruit) < 0) {
                // 分别将每个数组需要给对方的元素找出来，存储在list中并排序
                int moveToBasket1 = Math.abs(map.get(fruit)) / 2;
                // list2 存的是 basket2 要移走的 fruit
                for (int i = 0; i < moveToBasket1; i++) {
                    list2.add(fruit);
                }
            // 只有 basket1 才有    
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
        int i1 = 0, j1 = list1.size() - 1;
        int i2 = 0, j2 = list2.size() - 1;

        while (i1 <= j1 && i2 <= j2) {
            // 每次去除一对元素 从两个 list 中各取出一个【最小-最大成对取】
            if (list1.get(i1) <= list2.get(i2)) {
                /* 贪心：存在一种可能，交换这两个元素时，可以通过最小值工具瓜 min 实现交换 
                比如，对于【20】和【100】的交换，可以分别跟 工具瓜交换

                list1：【20，5】，假设工具瓜在篮子1里
                list2：【100】

                交换 5 跟 100，cost 为 5，
                【20，100】
                【5】，然后 5 再跟 20 交换，cost 为 5 again 

                【5，100】
                【20】实现了 20 和 100 的交换，总花费是 10，比 20 便宜
                */
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