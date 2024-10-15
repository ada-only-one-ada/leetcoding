class Solution {
    int[] segmentTree;

    /**
     * 求解最长递增子序列的长度，其中序列元素之间的最大差值不超过k
     *
     * @param nums 输入的整数数组
     * @param maxDiff 允许的最大差值k
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums, int maxDiff) {
        int maxValue = 0;
        for (int num : nums) maxValue = Math.max(maxValue, num);
        segmentTree = new int[maxValue * 4];
        for (int num : nums) {
            if (num == 1) {
                updateSegmentTree(1, 1, maxValue, 1, 1);
            } else {
                int res = 1 + querySegmentTree(1, 1, maxValue, Math.max(num - maxDiff, 1), num - 1);
                updateSegmentTree(1, 1, maxValue, num, res);
            }
        }
        return segmentTree[1];
    }

    /**
     * 更新线段树中的值
     *
     * @param nodeIndex 当前节点索引
     * @param left 当前节点表示的区间左端点
     * @param right 当前节点表示的区间右端点
     * @param idx 需要更新的位置
     * @param val 更新后的值
     */
    private void updateSegmentTree(int nodeIndex, int left, int right, int idx, int val) {
        if (left == right) {
            segmentTree[nodeIndex] = val;
            return;
        }
        int mid = (left + right) / 2;
        if (idx <= mid) {
            updateSegmentTree(nodeIndex * 2, left, mid, idx, val);
        } else {
            updateSegmentTree(nodeIndex * 2 + 1, mid + 1, right, idx, val);
        }
        segmentTree[nodeIndex] = Math.max(segmentTree[nodeIndex * 2], segmentTree[nodeIndex * 2 + 1]);
    }

    /**
     * 查询线段树中的最大值
     *
     * @param nodeIndex 当前节点索引
     * @param left 当前节点表示的区间左端点
     * @param right 当前节点表示的区间右端点
     * @param queryLeft 查询区间左端点
     * @param queryRight 查询区间右端点
     * @return 区间 [queryLeft, queryRight] 内的最大值
     */
    private int querySegmentTree(int nodeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft <= left && right <= queryRight) return segmentTree[nodeIndex];
        int res = 0;
        int mid = (left + right) / 2;
        if (queryLeft <= mid) {
            res = querySegmentTree(nodeIndex * 2, left, mid, queryLeft, queryRight);
        }
        if (queryRight > mid) {
            res = Math.max(res, querySegmentTree(nodeIndex * 2 + 1, mid + 1, right, queryLeft, queryRight));
        }
        return res;
    }
}
