class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
      
        int totalZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) totalZeros++;
        }
        
        // 右边为空的情况
        int max = totalZeros;
        res.add(nums.length);

        int rightZeros = 0;
        int rightOnes = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) rightOnes++;
            else rightZeros++;
            
            int score = totalZeros - rightZeros + rightOnes;
            if (score >= max) {
                if (score > max) {
                    max = score;
                    res.clear();
                }
                res.add(i);
            }
        }

        return res;
    }
}