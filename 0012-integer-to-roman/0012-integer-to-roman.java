class Solution {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500,  400,  100,  90,  50,   40,  10,  9,    5,   4,   1};
        String[] romans = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV","I"};

        TreeMap<Integer, String> treemap = new TreeMap<>();
        treemap.put(1000, "m");
        treemap.put(1000, "m");
        treemap.put(1000, "m");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++){
            int repeated = num / values[i];

            for (int no = 0; no < repeated; no++){
                sb.append(romans[i]);
            }

            num = num - repeated * values[i];
            // if (num <= 0) break;
        }

        return sb.toString();
    }
}