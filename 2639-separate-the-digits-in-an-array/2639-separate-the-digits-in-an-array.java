class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num: nums) {
            List<Integer> subList = new ArrayList<>();
            int leftOver = 0;

            while (num > 0) {
                int sum = leftOver + (num % 10);
                subList.add(sum % 10);

                leftOver = sum / 10;
                num = num / 10;
            }

            if (leftOver > 0) subList.add(leftOver);
            for (int i = subList.size() - 1; i >= 0; i--) {
                list.add(subList.get(i));
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}