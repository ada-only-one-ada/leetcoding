class Solution {
    public int hIndex(int[] citations) {
        // 这道题已经sorted好了，用二分法
        int res = 0;

        int left = 0;
        int right = citations.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int amount = citations.length - mid;
            
            // 满足条件的话，往左边走
            if (citations[mid] >= amount) {
                res = amount;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}