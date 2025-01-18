class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num: nums) {
            dp.add(num);
        }

        while (dp.size() > 1) {
            List<Integer> temp = new ArrayList<>();

            for (int col = 0; col + 1 < dp.size(); col++) {
                int sum = (dp.get(col) + dp.get(col + 1)) % 10;
                temp.add(sum);
            }

            dp = temp;
        }

        return dp.get(0);
    }
}