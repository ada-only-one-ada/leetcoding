class ExamRoom {
    // 存可以坐的区间，比如初始是 [0, n) 可以坐
    TreeSet<int[]> intervals = new TreeSet<>((a, b) -> {
        int distA = calculateDistance(a);
        int distB = calculateDistance(b);
        if (distA == distB) {
            return a[0] - b[0];  // 如果距离，坐到号数小的那里
        }
        return distB - distA;  // 否则坐到距离最大的interval去
    });

    Map<Integer, Integer> leftBoundary = new HashMap<>();
    Map<Integer, Integer> rightBoundary = new HashMap<>();
    int seatCount;

    public ExamRoom(int n) {
        this.seatCount = n;
        addInterval(new int[] {-1, n});  // 初始区间，表示整个考场
    }

    // 计算最佳位置
    public int calculateDistance(int[] interval) {
        int left = interval[0];
        int right = interval[1];
        if (left == -1 || right == seatCount) {
            return right - left - 1;  // 边缘距离，坐在边边
        }
        return (right - left) / 2;  // 中间距离，坐在两个点的中间
    }

    public int seat() {
        int[] longest = intervals.first();  // 选择最长的可坐区间
        
        int position;
        if (longest[0] == -1) {
            position = 0;  // 如果是最左端的区间，选择第一个座位
        } else if (longest[1] == seatCount) {
            position = seatCount - 1;  // 如果是最右端的区间，选择最后一个座位
        } else {
            position = (longest[0] + longest[1]) / 2;  // 否则选择中间位置
        }
        removeInterval(longest);
        addInterval(new int[] {longest[0], position});
        addInterval(new int[] {position, longest[1]});
        return position;
    }

    public void leave(int position) {
        int leftPos = leftBoundary.get(position);
        int rightPos = rightBoundary.get(position);
        removeInterval(new int[] {leftPos, position});
        removeInterval(new int[] {position, rightPos});
        addInterval(new int[] {leftPos, rightPos});
    }

    private void addInterval(int[] interval) {
        intervals.add(interval);
        leftBoundary.put(interval[1], interval[0]);
        rightBoundary.put(interval[0], interval[1]);
    }

    private void removeInterval(int[] interval) {
        intervals.remove(interval);
        leftBoundary.remove(interval[1]);
        rightBoundary.remove(interval[0]);
    }
}