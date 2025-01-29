class Solution {
    public boolean hasMatch(String s, String p) {
        // s = "l" and p = "*" return true
        // 如果星号在最前面
        if (p.charAt(0) == '*') return s.contains(p.substring(1));
        // 如果星号在最后面
        if (p.charAt(p.length() - 1) == '*') {
            return s.contains(p.substring(0, p.length() - 1));
        }

        // 找到星号位置
        int starIndex = p.indexOf("*");
        String before = p.substring(0, starIndex);
        String after = p.substring(starIndex + 1);

        // 找到左边的substring
        int firstPartIndex = s.indexOf(before);
        // 没找到左边，返回false
        if (firstPartIndex == -1) return false;

        // 从左边以后的位置开始找右边的
        int secondPartIndex = s.indexOf(after, firstPartIndex + before.length());
        // 没找到右边的，返回false
        if (secondPartIndex == -1) return false;

        // 返回true
        return true;
    }
}