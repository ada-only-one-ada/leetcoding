class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // 用一个array存0到n-1的index，以便后续排序
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 这个array根据nums2的值按从大到小排序 
        // Example 1排序后: indices = [3,2,0,1]
        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);

        // 用一个queue从小到大存nums1的元素，这样小的能够被poll出来
        Queue<Integer> queue = new PriorityQueue<>();

        // 优先队列用来维护当前选取的 k 个最大的nums1中的元素
        // 之后我就一个个对比看要不要把其中的元素替换掉
        long currSum = 0;
        // 选取nums2最大的前k个元素对应的nums1中的元素
        for (int i = 0; i < k; i++) {
            currSum += nums1[indices[i]];
            queue.offer(nums1[indices[i]]);
        }
        // 初始得分，是当前和乘以nums2中第k大的元素
        long maxSum = currSum * nums2[indices[k - 1]];

        // 继续遍历剩余的元素，尝试更新最大得分
        for (int i = k; i < n; i++) {
            // 只有当前nums1的数字比peek大，才有必要 poll
            // 因为此时的nums2的值肯定比之前的小 (从大到小排序，当前即最小)
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

/*
灵神真的好强！做题时没想清楚是按照nums[2]降序排列，把自己给绕晕了。
if x > h[0]这一句判断是理解的关键，如果在nums2选了一个系数更小的元素，
那么只有对应nums1的元素大于堆顶元素的情况下，得到的分数才有可能变大。
*/