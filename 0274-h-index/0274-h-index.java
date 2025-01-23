class Solution {
    public int hIndex(int[] citations) {
        /*
        [3,0,6,1,5]
        第一个paper：3个citation
        第二个paper：0个citation
        第三个paper：6个citation
        第四个paper：1个citation
        第五个paper：5个citation

        h-index的意思是：至少有 h 个 paper，被 cite 了至少 h 次
        返回最大的 h-index
        最大的就是数组的长度，因为只有那么多 paper

        [100] expected 1
        [0,0,2] expected 1
        [0] expected 0
        [11,15] expected 2 
        [1,7,9,4] expected 3
        */
        
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int amount = citations.length - i;

            if (citations[i] >= amount) {
                return amount;
            }
        }

        return 0;
    }
}