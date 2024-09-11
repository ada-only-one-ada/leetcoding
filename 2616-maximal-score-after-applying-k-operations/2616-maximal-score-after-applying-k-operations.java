class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int num: nums) {
            queue.add(num);
        }

        long score = 0;
        while (!queue.isEmpty() && k > 0) {
            int currBiggest = queue.poll();
            score += currBiggest;

            // 注意比如10/3，我们想要的是4
            int newCurr = (int)Math.ceil(currBiggest / 3); 
            if (currBiggest % 3 != 0) newCurr++;

            queue.add(newCurr);
            k--;
        }

        return score;
    }
}