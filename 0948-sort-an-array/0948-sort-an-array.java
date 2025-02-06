class Solution {
    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }

    public void countingSort(int[] nums) {
        if (nums.length == 0) return;

        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0];
        int max = nums[0];

        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int num = min; num <= max && index < nums.length; num++) {
            if (!map.containsKey(num)) continue;

            while (map.containsKey(num) && map.get(num) > 0) {
                nums[index++] = num;
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                } 
            }
        }
    }
}