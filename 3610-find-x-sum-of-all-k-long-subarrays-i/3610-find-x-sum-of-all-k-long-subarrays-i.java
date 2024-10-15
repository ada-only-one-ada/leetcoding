class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return a - b;
            }
            return map.get(a) - map.get(b);
        });

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Set<Integer> inQueue = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            if (right - left + 1 == k) {
                for (int key: map.keySet()) {
                    queue.add(key);
                    if (queue.size() > x) {
                        queue.poll();
                    }
                }

                int sum = 0;
                while (!queue.isEmpty()) {
                    sum += queue.peek() * map.get(queue.poll());
                }
                res[index++] = sum;

                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
        }

        return res;
    }
}