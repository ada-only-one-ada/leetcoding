class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 最多2个大于n/3，因为如果3个大于n/3，那么长度大于n，超过数组长度
        int candidateOne = -1;
        int freqOne = 0;

        int candidateTwo = -1;
        int freqTwo = 0;

        for (int num: nums) {
            if (num == candidateOne) {
                freqOne++;
            } else if (num == candidateTwo) {
                freqTwo++;
            } else if (num != candidateOne && num != candidateTwo) {
                if (freqOne == 0) {
                    candidateOne = num;
                    freqOne = 1;
                } else if (freqOne != 0 && freqTwo == 0) {
                    candidateTwo = num;
                    freqTwo = 1;
                } else {
                    freqOne--;
                    freqTwo--;

                    // 这里-1才需要真正被代替
                    if (freqOne == -1) {
                        candidateOne = num;
                        freqOne = 1;
                    } else if (freqTwo == -1) {
                        candidateTwo = num;
                        freqTwo = 1;
                    } 
                }
            }
        }

        freqOne = 0;
        freqTwo = 0;
        for (int num: nums) {
            if (num == candidateOne) freqOne++;
            else if (num == candidateTwo) freqTwo++;
        }

        List<Integer> res = new ArrayList<>();
        if (freqOne > nums.length / 3) res.add(candidateOne);
        if (freqTwo > nums.length / 3) res.add(candidateTwo);

        return res;
    }
}