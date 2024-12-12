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

            // 比如我遍历到3，这时候要移除index为0的，因为下一轮for loop是遍历到4的位置。
            if (i >= indexDiff) {
                int oldBucketId = getBucketId(nums[i - indexDiff]);
                map.remove(oldBucketId);
            }
        }
        return false;
    }

    public int getBucketId(int num) {
        if (num >= 0) {
            return num / bucketSize;
        } else {
            return (num + 1) / bucketSize - 1;
        }
    }
}