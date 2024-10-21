class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num: nums) {
            List<Integer> temp = new ArrayList<>();
            int leftover = 0;
            while (num > 0) {
                int sum = num % 10 + leftover;
                temp.add(sum % 10);
                leftover = sum / 10;
                num = num / 10;
            }
            if (leftover > 0) temp.add(leftover);
            
            for (int i = temp.size() - 1; i >= 0; i--) {
                list.add(temp.get(i));
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}