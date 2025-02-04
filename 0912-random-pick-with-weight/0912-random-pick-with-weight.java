class Solution {
    // 注意，Random是一个比较重的类，全局保留一个实例即可
    // 或者使用 Math.random() 或 ThreadLocalRandom.nextInt() 方法
    Random random;
    int[] prefixSum;

    public Solution(int[] w) {
        random = new Random();
      
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }
    
    /*
    w = [1, 2, 3, 4]
    prefixSum = [1, 3, 6, 10]
    maxRange: 10
    randNum is in range -> [0, 10) + 1 -> [1, 11) -> [1, 10]
    */
    public int pickIndex() {
        int maxRange = prefixSum[prefixSum.length - 1];
        int randNum = random.nextInt(maxRange) + 1;

        /*
        randNum: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        index: 0, 1, 2, 3
        
        判断randNum的范围落在哪个区间
        randNum <= 1: 1 (prefix：1)
        randNum <= 3: 2, 3 (prefix：3)
        randNum <= 6: 4, 5, 6 (prefix：6)
        randNum <= 10: 7, 8, 9, 10 (prefix：10)
        */        
        for (int index = 0; index < prefixSum.length; index++) {
            if (randNum <= prefixSum[index]) {
                return index;
            }
        }

        return -1;
    }
}