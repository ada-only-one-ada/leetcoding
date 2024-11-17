class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[]{a, b, c};
        Arrays.sort(stones);

        a = stones[0];
        b = stones[1];
        c = stones[2];

        // Max：a 和 c 一步步往 b 靠拢，(c-b-1) + (b-a-1) = c-a-2
        // 比如[1,2,5], 5往2走占3的位置花了2步：5到4，4到3

        // Min：
        // 1. c - a == 2, 已经是连续了，【2，3，4】，min=0
        // 2. b - a == 1 或者 c - b == 1，有一边是连续的，我们直接移动另一个，【2，3，8】，8到4，【2，8，9】，2到7，min=1
        // 3. b - a == 2 或者 c - b == 2，可以把另一个石头放到这两个石头之间，比如【1，3，9】，9到2，比如【2，9，11】，2到10，min=1
        // 4. 其他所有情况，a到b-1，c到b+1，min=2

        if (c - a == 2) {
            return new int[]{0, c-a-2};
        } else if (b - a <= 2 || c - b <= 2) {
            return new int[]{1, c-a-2};
        } else {
            return new int[]{2, c-a-2};
        }
    }
}