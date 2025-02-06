class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int totalOperations = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == 1) {
                // 如果任何数字的频率为1，不能通过任何操作删除它，直接返回-1。
                return -1;
            }
            // 首先尽可能使用“每三个一组”的操作
            int groupsOfThree = freq / 3;
            int remaining = freq % 3;

            // 计算使用“每三个一组”的操作次数
            totalOperations += groupsOfThree;

            // 对剩余的部分，如果有两个，使用“每两个一组”的操作一次
            if (remaining == 2) {
                totalOperations += 1;
            } else if (remaining == 1) {
                // 如果剩余一个，且之前有至少一个“每三个一组”的操作，可以调整一个“每三个一组”变为“每两个一组”
                if (groupsOfThree > 0) {
                    totalOperations++;  // 使用一个额外的“每两个一组”
                } else {
                    // 如果没有足够的数量来调整，返回-1
                    return -1;
                }
            }
        }

        return totalOperations;
    }
}
