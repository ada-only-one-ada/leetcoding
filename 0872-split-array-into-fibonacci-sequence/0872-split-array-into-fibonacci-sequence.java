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
            // 使用 break 可以直接退出整个循环，因为后续的更长数字都将无效地以0开始
            if (i > index && nums[index] == 0) break;

            long num = getNum(nums, index, i);
            
            // 如果计算出来的数字超过了 Integer.MAX_VALUE，那么更长的数字肯定也会超过 Integer.MAX_VALUE。继续循环没有意义
            if (num > Integer.MAX_VALUE) break;
            // 如果当前数字大于结果列表中最后两个数的和，这意味着任何更长的数字（即包含更多数字的组合）也会更大
            // 因此，没有必要继续增加更多的数字来尝试
            if (res.size() >= 2 && num > res.get(res.size() - 1) + res.get(res.size() - 2)) break;

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