class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer smallerEqual = treeSet.floor(nums[i]);
            Integer largerEqual = treeSet.ceiling(nums[i]);

            if (smallerEqual != null && nums[i] - smallerEqual <= valueDiff) return true;
            if (largerEqual != null && largerEqual - nums[i] <= valueDiff) return true;
            treeSet.add(nums[i]);

            // [11,8,4,11,19]，比如遍历到11，会把两个11都移除，不用担心因为移除11之前会检查所有符合的条件
            if (i >= indexDiff) {
                treeSet.remove(nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}