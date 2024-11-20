class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add((long) 1);
        int count = 0;
        Set<Long> set = new HashSet<>();

        while (!queue.isEmpty()) {
            long num = queue.poll();
            count++;
            if (count == n) return (int) num;

            long two = num * 2;
            if (!set.contains(two)) {
                queue.add(two);
                set.add(two);
            }

            long three = num * 3;
            if (!set.contains(three)) {
                queue.add(three);
                set.add(three);
            }

            long five = num * 5;
            if (!set.contains(five)) {
                queue.add(five);
                set.add(five);
            }
        }

        return -1;
    }
}