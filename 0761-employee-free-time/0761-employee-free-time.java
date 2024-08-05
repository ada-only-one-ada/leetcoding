class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        Queue<Interval> queue = new PriorityQueue<>((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        for (List<Interval> s: schedule) {
            for (Interval i: s) {
                queue.add(i);
            }
        }

        int preEnd = queue.poll().end;
        while (!queue.isEmpty()) {
            Interval curr = queue.poll();
            int currStart = curr.start;

            if (currStart > preEnd) {
                res.add(new Interval(preEnd, currStart));
            } 
            preEnd = Math.max(curr.end, preEnd);   
        }

        return res;
    }
}