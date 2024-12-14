class Solution {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500,  400,  100,  90,  50,   40,  10,  9,    5,   4,   1};
        String[] romans = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV","I"};

        StringBuilder res = new StringBuilder();
        // 因为我们的array是按照从大到小的，所以从左到右遍历
        for (int i = 0; i < values.length && num > 0; i++) {
            if (num < values[i]) continue;

            int times = num / values[i];
            for (int j = 0; j < times; j++) {
                res.append(romans[i]);
            }

            num -= values[i] * times;
        }

        return res.toString();
    }
}