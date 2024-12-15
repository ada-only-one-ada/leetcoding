class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((arrA, arrB) -> {
            return (arrA[0]+arrA[1]) - (arrB[0]+arrB[1]);
        });

        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{nums1[i], nums2[0], 0});
        };

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            int[] curr = queue.poll();
            int num1 = curr[0];
            int num2 = curr[1];
            int index2 = curr[2];
            res.add(new ArrayList<>(Arrays.asList(num1, num2)));
            k--;

            if (index2 + 1 < nums2.length) {
                queue.add(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }
        }

        return res;
    }
}