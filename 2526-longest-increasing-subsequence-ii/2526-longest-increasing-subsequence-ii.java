class Solution {
    int[] segmentTree; // 线段树数组，用于存储各个区间的最大值

    /**
     * 求解最长递增子序列的长度，其中序列元素之间的最大差值不超过k
     *
     * @param nums 输入的整数数组
     * @param maxDiff 允许的最大差值k
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums, int maxDiff) {
        int maxValue = 0;
        for (int num : nums) maxValue = Math.max(maxValue, num); // 计算数组中的最大值
        segmentTree = new int[maxValue * 4]; // 初始化线段树，大小为最大值的4倍
        
        for (int num : nums) {
            if (num == 1) { // 如果数字为1，无法形成递增关系，初始化为1
                updateSegmentTree(1, 1, maxValue, 1, 1);
            } else {
                // 查询以num结束的最长递增子序列长度
                int res = 1 + querySegmentTree(1, 1, maxValue, Math.max(num - maxDiff, 1), num - 1);
                updateSegmentTree(1, 1, maxValue, num, res); // 更新线段树，将索引为num的值设置为计算得到的长度
            }
        }
        return segmentTree[1]; // 线段树的根节点保存了整个数组的最长递增子序列长度
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
        if (left == right) { // 如果到达叶子节点，直接更新值，比如[1,1], [2,2]
            segmentTree[nodeIndex] = val;
            return;
        }

        int mid = (left + right) / 2; // 计算中点，用于分割区间
        if (idx <= mid) { // 判断更新的索引在左子树还是右子树
            updateSegmentTree(nodeIndex * 2, left, mid, idx, val);
        } else {
            updateSegmentTree(nodeIndex * 2 + 1, mid + 1, right, idx, val);
        }

        // 更新完子树后，需要更新当前节点的值为子节点的最大值
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
        // 如果当前区间完全在查询区间内，直接返回当前节点的值
        if (queryLeft <= left && right <= queryRight) {
            return segmentTree[nodeIndex]; 
        }
        
        int res = 0;
        int mid = (left + right) / 2; // 计算中点
        if (queryLeft <= mid) { // 如果查询区间与左子区间有交集，递归查询左子树
            res = querySegmentTree(nodeIndex * 2, left, mid, queryLeft, queryRight);
        }

        if (queryRight > mid) { // 如果查询区间与右子区间有交集，递归查询右子树
            res = Math.max(res, querySegmentTree(nodeIndex * 2 + 1, mid + 1, right, queryLeft, queryRight));
        }
        return res; // 返回查询结果
    }
}
