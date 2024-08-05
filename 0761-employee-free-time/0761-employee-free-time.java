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
                int start = i.start;
                int end = i.end;

                startQueue.add(start);
                endQueue.add(end);
            }   
        }

        List<Interval> res = new ArrayList<>();
        startQueue.poll();
        
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            if (endQueue.peek() < startQueue.peek()) {
                res.add(new Interval(endQueue.peek(), startQueue.peek()));
            } 

            startQueue.poll();
            endQueue.poll();
        }

        return res;

    }
}