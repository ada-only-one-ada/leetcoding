import java.util.*;

class Solution {
    // 大顶堆，用来存放当前窗口的较小一半元素
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    // 小顶堆，用来存放当前窗口的较大一半元素
    private PriorityQueue<Integer> big = new PriorityQueue<>();
    // 哈希表，用来记录窗口外的元素数量
    private Map<Integer, Integer> map = new HashMap<>();

    private double getMedian(int k) {
        // 如果 k 是奇数，中位数是大顶堆的根元素
        if (k % 2 != 0) return small.peek();
        // 如果 k 是偶数，中位数是大顶堆和小顶堆的根元素的平均值
        return small.peek() / 2.0 + big.peek() / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        // 先填满大顶堆
        for (int i = 0; i < k; i++) {
            small.add(nums[i]);
        }
        // 重新平衡两个堆，保证小顶堆和大顶堆的元素数量符合要求
        for (int i = 0; i < k / 2; i++) {
            big.add(small.poll());
        }
        // 添加初始窗口的中位数
        result.add(getMedian(k));
        // 开始滑动窗口
        for (int i = k; i < nums.length; i++) {
            int balance = 0;
            int l = nums[i - k];
            map.put(l, map.getOrDefault(l, 0) + 1);
            // 更新平衡因子
            if (!small.isEmpty() && l <= small.peek()) {
                balance--;
            } else {
                balance++;
            }
            if (!small.isEmpty() && nums[i] <= small.peek()) {
                small.add(nums[i]);
                balance++;
            } else {
                big.add(nums[i]);
                balance--;
            }
            // 重新平衡两个堆
            if (balance > 0) {
                big.add(small.poll());
            }
            if (balance < 0) {
                small.add(big.poll());
            }
            // 清理堆中不在窗口内的元素
            while (!small.isEmpty() && map.getOrDefault(small.peek(), 0) > 0) {
                map.put(small.peek(), map.get(small.peek()) - 1);
                small.poll();
            }
            while (!big.isEmpty() && map.getOrDefault(big.peek(), 0) > 0) {
                map.put(big.peek(), map.get(big.peek()) - 1);
                big.poll();
            }
            // 添加新的中位数
            result.add(getMedian(k));
        }
                return result.stream().mapToDouble(Double::doubleValue).toArray();

    }
}
