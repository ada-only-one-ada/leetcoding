class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtracking(s, 0, "");
        return res;
    }

    public void backtracking(String s, int index, String currRes) {
        if (index == s.length()) {
            res.add(new String(currRes));
            return;
        }

        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            backtracking(s, index + 1, currRes + Character.toLowerCase(c));
            backtracking(s, index + 1, currRes + Character.toUpperCase(c));
        } else {
            backtracking(s, index + 1, currRes + c);
        }
    }
}