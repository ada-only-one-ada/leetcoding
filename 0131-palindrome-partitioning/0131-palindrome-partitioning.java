class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(String s, List<List<String>> res, List<String> currRes, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String substring = s.substring(startIndex, i+1);
                currRes.add(substring);

                backtracking(s, res, currRes, i + 1);
                currRes.remove(currRes.size() - 1);
            }
        }
    }

    public boolean isPalindrome (String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}