class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        if (ruleKey.equals("type")) {
            res = check(items, 0, ruleValue);
        } else if (ruleKey.equals("color")) {
            res = check(items, 1, ruleValue);
        } else if (ruleKey.equals("name")) {
            res = check(items, 2, ruleValue);
        }

        return res;
    }

    public int check(List<List<String>> items, int index, String ruleValue) {
        int res = 0;
        for (List<String> item: items) {
            if (item.get(index).equals(ruleValue)) {
                res++;
            }
        }

        return res;
    }
}