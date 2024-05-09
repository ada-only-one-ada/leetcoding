class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{score[i], i});
        }

        String[] res = new String[score.length];
        int count = 0;
       
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            count++;
            if (count == 1) {
                res[pair[1]] = "Gold Medal";
            } else if (count == 2) {
                res[pair[1]] = "Silver Medal";
            } else if (count == 3) {
                res[pair[1]] = "Bronze Medal";
            } else {
                res[pair[1]] = String.valueOf(count);
            }
        }

        return res;
    }
}