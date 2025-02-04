class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        int currIndex = 0;
        while (true) {
            if (currIndex == heights.length - 1) {
                return currIndex;
            } 

            if (heights[currIndex] >= heights[currIndex + 1]) {
                currIndex++;
            } else {
                int diff = heights[currIndex + 1] - heights[currIndex];
                
                if (bricks >= diff) {
                    bricks -= diff;
                    currIndex++;
                    queue.add(diff);
                } else if (ladders > 0) {
                    if (!queue.isEmpty() && queue.peek() > diff) {
                        bricks += queue.poll();
                        ladders -= 1; // 注意这里不要立刻前进，因为还要继续判断当前需要的砖块是否小于queue里面的
                        //bricks -= diff;
                       // currIndex++;
                    } else {
                        ladders -= 1;
                        currIndex++;
                    }
                } else {
                    return currIndex;
                }
            }
        }
    }
}