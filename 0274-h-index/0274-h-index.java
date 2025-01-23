class Solution {
    public int hIndex(int[] citations) {
        /* 
        寻找一个数number：
           1.citations 数组中至少有 number 个数
           2.有number 个数都大于等于 number 
        
        e.g.
        [3,0,6,1,5] ->
        [0,1,3,5,6]
        有5个number大于等于0（5？no）
        有4个number大于等于1（4？no）
        有3个number大于等于3（3？yes） - max
        有2个number大于等于5（2？yes）
        有1个number大于等于6（1？yes）

        [1,3,1] ->
        [1,1,3]
        有3个number大于等于1（3？no）
        有2个number大于等于1（2？no）
        有1个number大于等于3（1？yes） - max
        */

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int cite = citations[i];

            int amount = citations.length - i;
            if (cite >= amount) {
                return amount;
            }
        }

        return 0;
    }
}