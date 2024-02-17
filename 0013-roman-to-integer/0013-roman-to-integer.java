class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char pre = s.charAt(i-1);

            if (getValue(curr) <= getValue(pre)) {
                res += getValue(pre);
            } else if (getValue(curr) > getValue(pre)) {
                res -= getValue(pre);
            }
        }

        res += getValue(s.charAt(s.length() - 1));
        return res;
    }

    public int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000; 

        return -1;   
    }
}