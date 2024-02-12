class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        
        for (int num : nums) {
            freq[num]++;
        }
        
        int duplicate = -1;
        int missing = -1;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                duplicate = i;
            } else if (freq[i] == 0) {
               missing = i;
            }
        }
        
        return new int[]{duplicate, missing};
    }
}