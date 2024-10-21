class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int leftover = 0;
            while (num > 0) {
                int sum = num % 10 + leftover;
                list.add(0, sum % 10);
                leftover = sum / 10;
                num = num / 10;
            }
            if (leftover > 0) list.add(0, leftover);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
