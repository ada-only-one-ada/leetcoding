class Solution {
    public String reverseWords(String s) {
        String wholeS = reverse(s);
        StringBuilder res = new StringBuilder();

        int start = 0;
        for (int end = 0; end < wholeS.length(); end++) {
            if (end > 0 && wholeS.charAt(end) == ' ' && wholeS.charAt(end - 1) != ' ') {
                res.append(reverse(wholeS.substring(start, end)));
                res.append(" ");
                start = end + 1;
            }
        }

        res.append(reverse(wholeS.substring(start, wholeS.length()))); // don't forget this
        return res.toString();
    }

    public String reverse(String s) {
        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
          left++;
        }
        
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
           right--;
        }

        StringBuilder sb = new StringBuilder(s.substring(left, right + 1));
        return sb.reverse().toString();
    }
}