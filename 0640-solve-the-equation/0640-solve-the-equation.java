class Solution {
    public String solveEquation(String equation) {
        String[] splits = equation.split("=");

        int[] left = formatFormula(splits[0]);
        int[] right = formatFormula(splits[1]);      

        if (left[0] == right[0] && left[1] == right[1]) return "Infinite solutions";
       
        int x = left[0] - right[0];
        int sum = right[1] - left[1];  
        if (x == 0) return "No solution";
        return "x=" + sum / x;
    }

    public int[] formatFormula(String s) {
        s += '+';
        int sign = 1;
        
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }

        int sum = 0;
        int x = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '+' && c != '-') {
                sb.append(c);
            } else {
                if (sb.charAt(sb.length() - 1) != 'x') {
                    sum += sign * (Integer.parseInt(sb.toString()));
                } else {
                    if (sb.length() == 1) {
                        x += sign * 1;
                    } else {
                        x += sign * (Integer.parseInt(sb.toString().substring(0, sb.length() - 1)));
                    }
                }

                sb.setLength(0);
                if (c == '+') sign = 1;
                else if (c == '-') sign = -1;
            }
        } 

        return new int[]{x, sum};
    }
}