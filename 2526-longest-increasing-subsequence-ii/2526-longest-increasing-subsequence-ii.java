class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int res = 0;
        // 找到nums中的最小和最大值，为了确定线段树的范围
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 创建线段树
        SegmentTree segTree = new SegmentTree(min, max);

        // 遍历数组，更新线段树并查询最大值
        for (int num : nums) {
            // 查询当前num-k到num-1的最大LIS长度
            int maxLIS = segTree.query(Math.max(min, num - k), num - 1) + 1;
            // 更新当前数的LIS长度
            segTree.update(num, maxLIS);
            // 更新结果
            res = Math.max(res, maxLIS);
        }

        return res;
    }
    
    class SegmentTree {
        int start, end;
        SegmentTree left, right;
        int max;

        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.max = 0;
            if (start != end) {
                int mid = start + (end - start) / 2;
                this.left = new SegmentTree(start, mid);
                this.right = new SegmentTree(mid + 1, end);
            }
        }

        public int query(int l, int r) {
            if (l > end || r < start) {
                return 0;
            }
            if (l <= start && end <= r) {
                return max;
            }
            return Math.max(left.query(l, r), right.query(l, r));
        }

        public void update(int idx, int value) {
            if (start == end) {
                max = Math.max(max, value);
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                left.update(idx, value);
            } else {
                right.update(idx, value);
            }
            max = Math.max(left.max, right.max);
        }
    }
}
