class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // 用一个 array 存 0 到 n-1 的 index
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 这个 array 根据 nums2 的数字按从大到小排序
        // Example 1 排序后: indices = [3,2,0,1]
        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);

        // 用一个 queue 从小到大 存 nums1 的元素，这样小的能够被 poll 出来
        Queue<Integer> queue = new PriorityQueue<>();

        // 先记录k个，之后我就一个个对比看要不要把 k 个换掉
        long currSum = 0;
        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums1[indices[i]];
            queue.offer(nums1[indices[i]]);
        }
        maxSum = currSum * nums2[indices[k - 1]];

        for (int i = k; i < n; i++) {
            // 只有 当前nums1 的数字比 peek 大，才有必要 poll
            // 因为此时的 nums2 的值肯定比之前的小 (从大到小排序, 当前即最小)
            if (nums1[indices[i]] > queue.peek()) {
                currSum -= queue.poll();
                currSum += nums1[indices[i]];
                queue.offer(nums1[indices[i]]);
                maxSum = Math.max(maxSum, currSum * nums2[indices[i]]);
            }
        }
        
        return maxSum;
    }
}