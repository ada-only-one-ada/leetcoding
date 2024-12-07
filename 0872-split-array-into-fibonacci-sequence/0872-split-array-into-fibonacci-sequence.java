class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = Character.getNumericValue(num.charAt(i));
        }
        backtracking(nums, res, 0);
        return res;
    }

    public boolean backtracking(int[] nums, List<Integer> res, int index) {
        if (index == nums.length && res.size() >= 3) {
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            // i > index 说明超过一位数，且首位是0，不符合题目要求
            if (i > index && nums[index] == 0) continue;

            long num = getNum(nums, index, i);
            if (num > Integer.MAX_VALUE) continue;
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) continue;

            if (res.size() < 2 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add((int) num);
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