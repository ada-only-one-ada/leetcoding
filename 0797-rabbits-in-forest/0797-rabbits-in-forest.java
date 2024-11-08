class Solution {
    public int numRabbits(int[] answers) {
        // [0,0,1,1,1] return 6
        //  1 1 2 0 2
        // 倒数第二只兔子被前一只兔子囊括在内了，不用计算 
       
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans: answers) {
            // 有效回答，新开一只兔子，这个颜色的兔子的数量是它回答的数量 + 1（它自己）
            if (!map.containsKey(ans)) {
                res += ans + 1;
                // 最多允许另外 ans 个 兔子跟它有一样的回答，这些兔子计算都被第一只回答的兔子囊括在内了
                map.put(ans, ans); 
            } else if (map.containsKey(ans)) {
                // 出现了已经被加入总数的兔子
                if (map.get(ans) > 0) {
                    map.put(ans, map.get(ans) - 1);
                    if (map.get(ans) == 0) {
                        map.remove(ans);
                    }
                // 不允许了，新开一只兔子
                } else if (map.get(ans) <= 0) {
                    res += ans + 1;
                    map.put(ans, ans);
                }
            }
        }
        return res;
    }
}