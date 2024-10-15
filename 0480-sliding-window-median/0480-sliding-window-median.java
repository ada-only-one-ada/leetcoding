class Solution {
    // 1,2,3,4,5
    // small: 1,2,3 -> 3,2,1 (从大到小存)
    // big: 4,5 （从小到大存）

    // 1,2,3,4
    // small: 1,2 -> 2,1 
    // big: 3,4
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // 这里不能用 b - a，不然会溢出
    PriorityQueue<Integer> big = new PriorityQueue<>();
    Map<Integer, Integer> removedMap = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        int balance = 0; // 平衡因子，用于调整两个堆的大小

        // 初始化第一个窗口
        // 分给small k个 (因为不一定有序，所以不能在一开始small分一半，big分一半)
        for (int i = 0; i < k; i++) {
            small.add(nums[i]);
            balance++;
        }
        // 这其中分给big一半
        for (int i = 0; i < k / 2; i++) {
            big.add(small.poll());
            balance -= 2;
        }
        // 第一个窗口的中位数结果
        result.add(getMedian(k));

        // 开始移动滑动窗口
        for (int right = k; right < nums.length; right++) {  
            int leftNum = nums[right - k]; // 即将被移出窗口的元素
            removedMap.put(leftNum, removedMap.getOrDefault(leftNum, 0) + 1); // 标记该元素将移除窗口

            // 判断即将移出的元素在哪个堆中，并调整平衡因子
            // 被移除的数字等于或小于 small 的堆顶，在 small 堆中
            // 这里 balance 可以实际上加减，在我们心目中已经去掉了
            if (!small.isEmpty() && leftNum <= small.peek()) {
                balance--; // small 失去了一个元素
            // 否则在 big 堆中
            } else {
                balance++; // big 失去了一个元素
            }

            // 将新元素加入合适的堆，并调整平衡因子
            if (!small.isEmpty() && nums[right] <= small.peek()) {
                small.add(nums[right]);
                balance++; // small 增加了一个元素
            } else {
                big.add(nums[right]);
                balance--; // big 增加了一个元素
            }

            // 调整平衡状态：
            // 理想状态下的 balance：
            // k 是偶数： balance = 0，表示 small 和 big 一样
            // k 是奇数： balance = 1，表示 small 比 big 多一个

            if ((k%2==0 && balance > 0) || (k%2 != 0 && balance > 1)) {
                big.add(small.poll());
                balance -= 2; // small 移动一个元素到 big
            }

            // 说明big比small多了
            if (balance < 0) {
                small.add(big.poll());
                balance += 2; // big 移动一个元素到 small
            }
            
            // 清除延迟删除的元素
            while (!small.isEmpty() && removedMap.getOrDefault(small.peek(), 0) > 0) {
                removedMap.put(small.peek(), removedMap.get(small.peek()) - 1);
                small.poll();
            }

            while (!big.isEmpty() && removedMap.getOrDefault(big.peek(), 0) > 0) {
                removedMap.put(big.peek(), removedMap.get(big.peek()) - 1);
                big.poll();
            }

            result.add(getMedian(k));
        }

        double[] arr = new double[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public double getMedian(int k) {
        if (k % 2 != 0) {
            return small.peek();
        } else {
            return small.peek() / 2.0 + big.peek()/ 2.0;
        }
    }
}