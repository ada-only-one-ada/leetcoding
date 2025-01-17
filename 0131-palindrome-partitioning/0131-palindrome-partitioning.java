class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(String s, List<List<String>> res, List<String> currRes, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);

            if (isPalindrome(substring)) {
                currRes.add(substring);

                backtracking(s, res, currRes, i + 1);
                currRes.remove(currRes.size() - 1);
            }
        }
    }

    // 检查是否是 palindrome
    public boolean isPalindrome(String s) {
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