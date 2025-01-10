class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) return 0; // start is the destination, no need to move
        int steps = 0;
        
        int start = 0;
        int currFar = 0;
        int nextFar = 0;
        while (currFar < nums.length - 1) { // we don't need to iterate the last element: destination
            for (int i = start; i <= currFar; i++) { // 当前覆盖范围，可以走到的最远的地方，即记录下一次可以跳的覆盖范围
                nextFar = Math.max(i + nums[i], nextFar);
            }

            start = currFar + 1; // start++ is also working
            steps++; // 当前覆盖范围走不动了，要开始下一个覆盖范围
            currFar = nextFar;
            if (currFar >= nums.length - 1) break;
           
        }

        return steps;   
    }
}