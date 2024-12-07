class Solution {
    public int findMinMoves(int[] machines) {
        // 注意题目：相邻洗衣机！
        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }

        if (sum == 0) return 0;
        if (sum % machines.length != 0) return -1;
        int target = sum / machines.length;

        int max = 0;
        int state = 0;

        for (int i = 0; i < machines.length; i++) {
            int change = machines[i] - target; // 当前洗衣机可能有很多衣服要被移走
            max = Math.max(max, change); // 更新最大改变
            
            state += machines[i] - target; // 当前这台洗衣机需要的总变化（包括经过这台洗衣机的）
            max = Math.max(max, Math.abs(state)); // 更新最大改变
        }  

        return max;
    }
}