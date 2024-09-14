public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        // 创建一个数组来存储索引，以便于后续排序
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 根据 nums2 的值降序排序 indices
        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);

        // 优先队列用来维护当前选取的 k 个最大的 nums1 中的元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0; // 当前选取的 nums1 元素之和

        // 选取 nums2 最大的前 k 个元素对应的 nums1 中的元素
        for (int i = 0; i < k; i++) {
            currentSum += nums1[indices[i]];
            minHeap.offer(nums1[indices[i]]);
        }

        // 初始得分，是当前和乘以 nums2 中第 k 大的元素
        long maxScore = currentSum * nums2[indices[k - 1]];

        // 继续遍历剩余的元素，尝试更新最大得分
        for (int i = k; i < n; i++) {
            int currentNum = nums1[indices[i]];
            if (currentNum > minHeap.peek()) {
                // 如果当前元素比堆中最小元素大，进行替换
                currentSum += currentNum - minHeap.poll();
                minHeap.offer(currentNum);
                // 更新得分
                maxScore = Math.max(maxScore, currentSum * nums2[indices[i]]);
            }
        }

        return maxScore;
    }
}
