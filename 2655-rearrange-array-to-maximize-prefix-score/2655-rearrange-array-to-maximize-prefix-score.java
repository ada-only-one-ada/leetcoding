class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int num: nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int res = 0;
        long prefixSum = 0;

        int i = pos.size() - 1;
        int j = neg.size() - 1;

        while (i >= 0 && j >= 0) {
            prefixSum += pos.get(i);
            i--;
            if (prefixSum > 0) res++;

          
        }

        while (i >= 0) {
            prefixSum += pos.get(i);
            i--;
            if (prefixSum > 0) res++;
        }

        while (j >= 0) {
            prefixSum += neg.get(j);
            j--;
            if (prefixSum > 0) res++;
        }

        System.out.println(prefixSum);
        return res;
    }
}