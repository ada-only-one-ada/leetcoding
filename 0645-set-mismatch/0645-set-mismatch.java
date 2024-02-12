class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        
        for (int num : nums) {
            freq[num]++;
        }
        
        int[] res = new int[2];
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                res[0] = i;
            } else if (freq[i] == 0) {
                res[1] = i;
            }
        }
        
        return res;
    }
}