class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = nums[0];
        int startIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                if (startIndex == i || startIndex + 1 == i) {
                    res.add(start + "");
                } else {
                    res.add(start + "->" + nums[i-1]);
                }
                start = nums[i];
                startIndex = i;
            }
        }

        if (startIndex == nums.length - 1) {
            res.add(start + "");
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}