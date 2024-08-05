/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Integer> startQueue = new PriorityQueue<>();
        Queue<Integer> endQueue = new PriorityQueue<>();

        for (List<Interval> s: schedule) {
            for (Interval i: s) {
                startQueue.add(i.start);
                endQueue.add(i.end);
            }   
        }

        List<Interval> res = new ArrayList<>();
        startQueue.poll();

        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            int preEnd = endQueue.poll();
            int currStart = startQueue.poll();

            if (currStart > preEnd) {
                res.add(new Interval(preEnd, currStart));
            } 
        }

        return res;

    }
}