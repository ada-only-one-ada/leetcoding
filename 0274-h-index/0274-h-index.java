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
            // 包含当前的，和之后的数字一共有几个
            int amount = citations.length - i;

            //  0 1 2 3 4
            // [0,1,3,5,6]
            // i = 2，此时 citaion 是 3，amount 是 3
            // citation 3 是大于等于 amount 3 的

            // [100]
            // i = 0，此时citations 是 100，amount 是 1
            // citaion 100 是大于等于 amont 1 的
            if (citations[i] >= amount) {
                return amount;
            }
        }

        return 0;
    }
}