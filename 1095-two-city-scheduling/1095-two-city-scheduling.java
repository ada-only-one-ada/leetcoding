class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int total = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            total += costs[i][0];
        }

        for (int i = costs.length / 2; i < costs.length; i++) {
            total += costs[i][1];
        }

        return total;
    }
}