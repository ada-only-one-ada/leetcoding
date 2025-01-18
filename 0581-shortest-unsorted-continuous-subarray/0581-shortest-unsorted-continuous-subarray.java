class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 左边最大，右边最小
        // 要比左边最大大，要比右边最小小
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        // 注意这里初始化，不然是 0
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);   
        }

        // 注意这里初始化，不然是 0
        min[min.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--){
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }

        int start = 0;
        int end = 0;

        for (int i = max.length - 1; i >= 0; i--) {
            if (nums[i] < max[i] || nums[i] > min[i]) {
                start = i;
            }
        }

        for (int i = 0; i < min.length; i++) {
            if (nums[i] < max[i] || nums[i] > min[i]) {
                end = i;
            }
        }

        if (start == end) return 0; 
        return end - start + 1;
    }
}