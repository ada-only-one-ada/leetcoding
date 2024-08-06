class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetterOrDigit(c)) continue;
          
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        String original = sb.toString();
        String reverse = sb.reverse().toString();
        return original.equals(reverse);
    }
}