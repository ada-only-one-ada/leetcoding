class Solution {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500,  400,  100,  90,  50,   40,  10,  9,    5,   4,   1};
        String[] romans = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV","I"};

        TreeMap<Integer, String> treemap = new TreeMap<>();
        treemap.put(1000, "M");
        treemap.put(900, "CM");
        treemap.put(500, "D");
        treemap.put(400, "CD");
        treemap.put(100, "C");
        treemap.put(90, "XC");
        treemap.put(50, "L");
        treemap.put(40, "XL");
        treemap.put(10, "X");
        treemap.put(9, "IX");
        treemap.put(5, "V");
        treemap.put(4, "IV");
        treemap.put(1, "I");

        StringBuilder res = new StringBuilder();
        while (num > 0) {
            // 找到最大的，小于等于当前数字的
            int lastEqualSmaller = treemap.floorKey(num);
            int times = num / lastEqualSmaller;

            for (int i = 0; i < times; i++) {
                res.append(treemap.get(lastEqualSmaller));
            }
            num -= lastEqualSmaller * times;
        }

        return res.toString();
    }
}