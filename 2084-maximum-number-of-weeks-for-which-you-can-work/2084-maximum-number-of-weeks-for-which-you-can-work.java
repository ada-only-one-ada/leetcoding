class Solution {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);

        long sum = 0;
        for (int mi: milestones) {
            sum += mi;
        }
        // [5, 2, 1]，从小到大排序，先做的5，那么下一个task至少可以做
        // 5_5_5_5_5，这里的5不能做满因为不够tasks隔开，只能 5 2 5 2 5 1 5，做4个，也就是剩余之和 3 + 1 = 4
        // tasks的数量，和最多能做的，取小的
        long firstlyCanDo = Math.min(milestones[milestones.length - 1], sum - milestones[milestones.length - 1] + 1);

        long res = firstlyCanDo;
        long prev =  firstlyCanDo;

        for (int i = milestones.length - 2; i >= 0; i--) {
            // 当前最多能做 prev * 2个tasks，1个换2个，2个换4个
            long canDo = Math.min(milestones[i], prev * 2);
            res += canDo;
            prev = canDo;
        }

        return res;
    }
}