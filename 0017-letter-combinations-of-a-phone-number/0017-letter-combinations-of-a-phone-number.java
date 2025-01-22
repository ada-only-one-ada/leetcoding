class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, res, mapping, "", 0);
        return res;
    }

    public void backtracking(String digits, List<String> res, String[] mapping, String currRes, int index) {
        if (index == digits.length()) {
            res.add(currRes);
            return;
        }

        int num = Character.getNumericValue(digits.charAt(index));
        String options = mapping[num];

        for (int i = 0; i < options.length(); i++) {
            backtracking(digits, res, mapping, currRes + options.charAt(i), index + 1);
        }
    }
}