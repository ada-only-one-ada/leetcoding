class Solution {
    Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> big = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        int balance = 0; 
        for (int i = 0; i < k; i++) {
            small.add(nums[i]);
            balance++;
        }
        for (int i = 0; i < k / 2; i++) {
            big.add(small.poll());
            balance -= 2;
        }
        result.add(getMedian(k));
        for (int right = k; right < nums.length; right++) {  
            int leftNum = nums[right - k]; 
            map.put(leftNum, map.getOrDefault(leftNum, 0) + 1);
            if (!small.isEmpty() && leftNum <= small.peek()) balance--; 
            else balance++; 
            if (!small.isEmpty() && nums[right] <= small.peek()) {
                small.add(nums[right]);
                balance++;
            } else {
                big.add(nums[right]);
                balance--;
            }
            if (balance > 1) {
                big.add(small.poll());
                balance -= 2; 
            }
            if (balance < 0) {
                small.add(big.poll());
                balance += 2; 
            }
            while (!small.isEmpty() && map.getOrDefault(small.peek(), 0) > 0) {
                map.put(small.peek(), map.get(small.poll()) - 1);               
            }
            while (!big.isEmpty() && map.getOrDefault(big.peek(), 0) > 0) {
                map.put(big.peek(), map.get(big.poll()) - 1);
            }

            result.add(getMedian(k));
        }
        double[] arr = new double[result.size()];
        for (int i = 0; i < result.size(); i++)arr[i] = result.get(i);
        return arr;
    }

    public double getMedian(int k) {
        if (k % 2 != 0) return small.peek();
        return small.peek() / 2.0 + big.peek()/ 2.0;
    }
}