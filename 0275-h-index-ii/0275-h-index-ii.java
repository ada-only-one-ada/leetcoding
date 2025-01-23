class Solution {
    public int hIndex(int[] citations) {
        // 这道题已经sorted好了，用二分法
        int res = 0;

        int left = 0;
        int right = citations.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int amount = citations.length - mid;
            
            // 满足条件的话，忘左边走
            if (citations[mid] >= amount) {
                res = amount;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}