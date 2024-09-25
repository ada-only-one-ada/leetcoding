class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
        }

        int hill = 0;
        int valley = 0;

        for (int i = 1; i < list.size() - 1; i++) {
            int leftNei = list.get(i - 1);
            int rightNei = list.get(i + 1);
            int curr = list.get(i);
            
            if (curr < leftNei && curr < rightNei) {
                valley++;
            } else if (curr > leftNei && curr > rightNei) {
                hill++;
            }
        }

        return hill + valley;
    }
}