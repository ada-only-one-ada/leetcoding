class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 累加统计走到每个站点剩余的油量
        // 如果是负数，那么无论从之前或当前的哪个站点出发都是不可能的
        // 只能选择 i + 1 作为新的起始站点
    
        int leftoverSum = 0;
        int candidate = 0;

        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            leftoverSum += gas[i] - cost[i];

            if (leftoverSum < 0) {
                leftoverSum = 0;
                candidate = i + 1;
            }
        }     

        // 总油量小于总花费，肯定不能跑
        if (totalGas < totalCost) return -1;
        return candidate;
    }
}
/* 
走到 i 点时，leftoverSum < 0，能从 i 之前截取一点作为起始站点吗？
第一段 + 第二段 < 0
第二段作为开始的话，那就要第二段 > 0, 那么第一段一定 < 0
那么自动就取到第一段后面的 i 作为开始了
*/