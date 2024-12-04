class Solution {
    public long numberOfWeeks(int[] milestones) {
        long maxMi = 0; // 用于存储最大的里程碑值
        long sum = 0;   // 用于存储所有里程碑的总和

        // 遍历每个里程碑
        for (int mi : milestones) {
            sum += mi; // 累加总和
            maxMi = Math.max(mi, maxMi); // 更新最大里程碑值
        }

        // 判断最大里程碑值是否大于其他所有里程碑的总和
        if (maxMi > sum - maxMi) {
            // 如果最大里程碑的工作量过大，则无法连续工作完成所有里程碑
            // 最多可以完成的周数是其他里程碑总和的两倍加一（每个最大里程碑间可以安排一个其他任务），
            // 并再加上一个最大里程碑的机会
            return 2 * (sum - maxMi) + 1;
        } else {
            // 如果没有任何单个里程碑的工作量过大，可以顺利完成所有里程碑
            // 直接返回总周数
            return sum;
        }
    }
}
