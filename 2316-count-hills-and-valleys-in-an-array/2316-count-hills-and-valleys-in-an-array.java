class Solution {
    public int countHillValley(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 &&  nums[i] == nums[i - 1]) continue;

            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && nums[left] == nums[i]) left--;
            while (right < nums.length && nums[right] == nums[i]) right++;

            if (left >= 0 && nums[i] > nums[left] && right < nums.length && nums[i] > nums[right] || 
                left >= 0 && nums[i] < nums[left] && right < nums.length && nums[i] < nums[right]) {
                res++;
            } 
        }

        return res;
    }
}