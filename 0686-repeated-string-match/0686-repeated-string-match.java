class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        String curr = "";

        // 至少长度要跟b的一样
        while (curr.length() < b.length()) {
            curr += a;
            count++;
        }

        if (curr.contains(b)) return count;

        // 一次循环 
        curr += a;
        count++;
        if (curr.contains(b)) return count;

        return -1;
    }
}