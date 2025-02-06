class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (a[0]+a[1]) - (b[0]+b[1]);
        });

        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            queue.add(new int[]{nums1[0], nums2[i], 0});
        }

        while (res.size() < k && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int i1 = pair[2];

            res.add(new ArrayList(Arrays.asList(num1, num2)));
            if (i1+1 < nums1.length) {
                queue.add(new int[]{nums1[i1+1], num2, i1+1});
            }
        }

        return res;
    }
}