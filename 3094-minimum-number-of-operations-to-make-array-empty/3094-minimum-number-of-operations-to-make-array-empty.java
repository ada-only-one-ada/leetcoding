class Solution {
    public int minOperations(int[] nums) {
        // 选两个一样的删除
        // 选三个一样的删除

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;

        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (freq <= 1) return -1;

            if (freq % 3 == 0) {
                res += freq / 3;
            } else {
                while (freq >= 2) {
                    if (freq >= 3) {
                        res += freq / 3;
                        freq = freq - (freq / 3) * 3;
                    } else if (freq >= 2) {
                        res += freq / 2;
                        freq = freq - (freq / 2) * 2;
                    }
                }

                if (freq > 0) res++;
            }
        }

        return res;
    }
}

/*
2:4 
3:3
4:2
*/