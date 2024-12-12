class Solution {
    int bucketSize;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        bucketSize = valueDiff + 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currBucketId = getBucketId(nums[i]);
            if (map.containsKey(currBucketId)) return true;

            int prevBucketId = currBucketId - 1;
            int nextBucketId = currBucketId + 1;
            if (map.containsKey(prevBucketId) && nums[i] - map.get(prevBucketId) <= valueDiff) return true;
            if (map.containsKey(nextBucketId) && map.get(nextBucketId) - nums[i] <= valueDiff) return true;

            map.put(currBucketId, nums[i]);

            if (i >= indexDiff) {
                int oldBucketId = getBucketId(nums[i - indexDiff]);
                map.remove(oldBucketId);
            }
        }
        return false;
    }

    private int getBucketId(int number) {
        return number >= 0 ? number / bucketSize : (number + 1) / bucketSize - 1;
    }
}