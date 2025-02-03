class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    int num = nums2[stack.pop()];
                    if (!map.containsKey(num)) continue;
                    res[map.get(num)] = nums2[i]; 
                }
                stack.push(i);
            }
        }

        return res;
    }
}