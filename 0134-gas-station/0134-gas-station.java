class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int leftover = 0;
        int candidate = 0;

        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            leftover += gas[i] - cost[i];

            totalGas += gas[i];
            totalCost += cost[i];

            if (leftover < 0) {
                leftover = 0;
                candidate = i + 1;
            }
        }

        if (totalGas < totalCost) return -1;
        return candidate;
        
    }
}