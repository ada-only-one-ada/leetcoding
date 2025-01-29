class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() == nums.length) return 0;
        int operations = 0;

        int removeIndex = 0;
        while (map.size() != nums.length - removeIndex && removeIndex < nums.length) {
            if (removeIndex + 2 < nums.length) {
                int removeNum = nums[removeIndex];
                int removeNum1 = nums[removeIndex + 1];
                int removeNum2 = nums[removeIndex + 2];

                map.put(removeNum, map.getOrDefault(removeNum, 0) -  1);
                if (map.get(removeNum) <= 0) map.remove(removeNum);

                map.put(removeNum1, map.getOrDefault(removeNum1, 0) -  1);
                if (map.get(removeNum1) <= 0) map.remove(removeNum1);

                map.put(removeNum2, map.getOrDefault(removeNum2, 0) -  1);

                if (map.get(removeNum2) <= 0) map.remove(removeNum2);
                removeIndex += 3;
            } else if (removeIndex + 1 < nums.length) {
                int removeNum = nums[removeIndex];
                int removeNum1 = nums[removeIndex + 1];

                map.put(removeNum, map.getOrDefault(removeNum, 0) -  1);
                if (map.get(removeNum) <= 0) map.remove(removeNum);

                map.put(removeNum1, map.getOrDefault(removeNum1, 0) -  1);
                if (map.get(removeNum1) <= 0) map.remove(removeNum1);
                removeIndex += 2;
            } else if (removeIndex < nums.length) {
                int removeNum = nums[removeIndex];
        
                map.put(removeNum, map.getOrDefault(removeNum, 0) -  1);
               
                if (map.get(removeNum) <= 0) map.remove(removeNum);
                removeIndex += 1;
            }
            operations++;
        }

        return operations;
    }
}