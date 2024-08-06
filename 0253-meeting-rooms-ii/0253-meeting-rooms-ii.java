class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        Queue<Integer> queue = new PriorityQueue<>();
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            if (queue.isEmpty() || start < queue.peek()) {
                queue.add(end);
            } else {
                queue.poll();
                queue.add(end);
            }
        }

        return queue.size();
    }
}