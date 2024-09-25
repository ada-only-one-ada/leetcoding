class Solution {
    public boolean validPalindrome(String s) {
        if (helper(s)) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 这里不用记录改变过没有，因为一旦遇到不相等的字符，我们只能选择去掉左边/右边的再看是否全等
            // 此时如果不全等的话就return false了，也就没有下一次的删除操作了（which means used might increase）
            if (s.charAt(left) != s.charAt(right)) { 
                return helper(s.substring(left, right)) || helper(s.substring(left + 1, right + 1));
            }

            left++;
            right--;
            
        }
        return false;
    }

    public boolean helper(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}