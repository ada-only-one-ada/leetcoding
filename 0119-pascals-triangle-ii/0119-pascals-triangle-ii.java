class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList<>();
        if (rowIndex == 0) {
            dp.add(1);
            return dp;
        }
        
        for (int row = 0; row < rowIndex; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for (int col = 1; col < dp.size(); col++) {
                temp.add(dp.get(col) + dp.get(col - 1));
            }

            temp.add(1);

            dp = temp;
        }

        return dp;
    }
}