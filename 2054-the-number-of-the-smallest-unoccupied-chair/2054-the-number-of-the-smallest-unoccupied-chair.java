class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // 先保存这个朋友到达的时间，题目说了每个人到达时间不一样
        int arrival = times[targetFriend][0];
        // 存目前可用的所有椅子，初始化是所有椅子都加进去
        Queue<Integer> seats = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            seats.add(i);
        }
        // 按到达时间从早到晚排列
        Arrays.sort(times, (a, b) -> {
            return a[0] - b[0];
        });

        Queue<Pair<Integer, Integer>> seatToEndTime = new PriorityQueue<>((a, b) -> {
            // 按离开时间从早到晚排列
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            };
            // 一样的话，按照椅子号小的排
            return a.getKey() - b.getKey();
        });

        for (int i = 0; i < times.length; i++) {
            // 把目前能离开的朋友都先清走，把他们的椅子加入克坐队列
            while (!seatToEndTime.isEmpty() && times[i][0] >= seatToEndTime.peek().getValue()) {
                seats.add(seatToEndTime.poll().getKey());
            }

            // 如果这个到达的是要找的朋友的到达时间
            if (times[i][0] == arrival) {
                // 返回当前最小的座位号
                return seats.peek();
            }

            // 把当前朋友的（座位号，结束时间）加入队列
            seatToEndTime.add(new Pair(seats.poll(), times[i][1]));
        }

        return 0;
    }
}