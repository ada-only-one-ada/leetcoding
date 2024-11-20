class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (a[0]+a[1]) - (b[0]+b[1]);
        });

        // 初始将nums1的第一个元素和nums2的每个元素的组合加入队列 (优化前k对)
        // 存储 nums1 元素值，nums2 元素值，和 nums1 的当前索引：num1, num2[i], i1 
        // Time Complexity: O(Min(k, nums2.length) * logk)
        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            queue.add(new int[]{nums1[0], nums2[i], 0});
        }

        // 迭代 k 次或直到队列为空
        // Time Complexity: O(klogk)
        while (k > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            int num1 = curr[0]; // nums1 中的值
            int num2 = curr[1]; // nums2 中的值
            int i1 = curr[2]; // num1 的index
            res.add(new ArrayList(Arrays.asList(num1, num2)));

            // 如果当前 num1 的index还可以增加，则继续添加新的组合到队列中
            if (i1 + 1 < nums1.length) {
                queue.add(new int[]{nums1[i1 + 1], num2, i1 + 1});
            }

            k--;
        }

        return res;   
    }
}