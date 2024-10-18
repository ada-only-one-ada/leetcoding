class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                total += costs[i][0]; // first half to A
            } else {
                total += costs[i][1]; // second half to B
            }
        }

        return total;
    }
}

// [[70,311], [74,927], [732,711], [97,928]]
// 选 A 的代价: [70-311]=-241, [74-927]=-853, [732,711]=21, [97-928]=-831
// 按从低到高排序[74-927]=-853,[97-928]=-831, [70-311]=-241,[732,711]=21,
// 所以前一半飞去代价最小的 A，[74-927]=-853,[97-928]=-831,总cost为74+97=171
// 剩下的自然全都飞去 B了，[70-311]=-241,[732,711]=21,总cost为311+711=1022
// total: 1193