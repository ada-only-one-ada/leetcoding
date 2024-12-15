class Solution {
    public String reverseWords(String s) {
        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }

        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        s = s.substring(left, right + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i-1) == ' ') continue;
            sb.append(s.charAt(i));
        }

        sb = sb.reverse();
        StringBuilder res = new StringBuilder();
        
        int start = 0;
        for (int end  = 0; end < sb.length(); end++) {
            if (sb.charAt(end) == ' ') {
                res.append(reverseSingle(sb.substring(start, end)));
                res.append(' ');
                start = end + 1;
            }
        }

        res.append(reverseSingle(sb.substring(start, sb.length())));
        return res.toString();
    }

    public String reverseSingle(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}