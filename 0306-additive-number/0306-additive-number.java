class Solution {
    public boolean isAdditiveNumber(String num) {
        List<Long> res = new ArrayList<>();
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = Character.getNumericValue(num.charAt(i));
        }

        backtracking(nums, res, 0);
        return res.size() >= 3;
    }

    public boolean backtracking(int[] nums, List<Long> res, int index) {
        if (index == nums.length && res.size() >= 3) {
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[index] == 0) break;

            long num = getNum(nums, index, i);
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) break;

            if (res.size() < 2 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add(num);
                if (backtracking(nums, res, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    public long getNum(int[] nums, int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum * 10 + nums[i];
        }

        return sum;
    }
}