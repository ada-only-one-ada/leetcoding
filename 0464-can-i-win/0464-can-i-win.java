class Solution {
    int[] picked;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 优化：提前判断
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

        // 初始化 picked 数组，大小为 2^(maxChoosableInteger + 1)，从 0 开始 选
        picked = new int[1 << (maxChoosableInteger + 1)];

        // 候选集，「公共整数池」，开始时，state = 0，表示「公共整数集」中的所有数字都未被使用过
        int state = 0;
        // 判断当前做选择的玩家（先手），是否一定赢
        return dfs(state, 0, maxChoosableInteger, desiredTotal);
    }
    
    // 当前做选择的玩家是否一定赢
    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
         // 如果状态已经计算过
        if (picked[state] == 1) return true;
        if (picked[state] == -1) return false;

        // 遍历可选择的公共整数
        for (int x = 1; x <= maxChoosableInteger; x++) {
            // 如果 x 已经被使用过了，则不能选择
            // 这行代码用于检查数字 x 是否已经被使用过
            // 1 << x 是将 1 向左移动 x 位，生成一个只有第 x 位为 1 的整数
            // state & (1 << x) 是对 state 和 1 << x 进行按位与操作，如果结果不为0，则说明 x 已经被选择过
            if ((state & (1 << x)) != 0) continue;

            // 如果选择了 x 以后，大于等于了 desiredTotal，当前玩家赢
            if (sum + x >= desiredTotal) {
                picked[state] = 1;
                return true;
            }
         
            // 当前玩家选择了 x 以后，判断对方玩家一定输吗？
            // 更新「state」，表示将数字 x 标记为已使用
            // 1 << x 是将 1 向左移动 x 位，生成一个只有第 x 位为 1 的整数
            // 使用 ｜ 将这个值与state值进行按位或操作，从而将 x 位置 为 1，表示 x 已经被选择
            if (!dfs(((1 << x) | state), sum + x, maxChoosableInteger, desiredTotal)) {
                picked[state] = 1;
                return true;
            }
        }
        
        // 标记当前状态为对手赢的状态
        picked[state] = -1;
        return false;
    }
}
