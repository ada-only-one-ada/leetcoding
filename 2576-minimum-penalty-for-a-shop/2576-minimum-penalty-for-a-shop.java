class Solution {
    public int bestClosingTime(String customers) {        
        int earliestClosingHour = customers.length();
        // 最大化分数
        // 也就是之后的的yes越来越少
        int score = 0;
        int maxScore = 0;

       // 因为是从后往前遍历，所以如果越往前， N 越多时 score 的值便会越大，那么便会越早关门
        for (int i = customers.length() - 1; i >= 0; i--) {
            char c = customers.charAt(i);

            if (c == 'Y') {
                score--;
            } else if (c == 'N') {
                score++;
            }

            if (score >= maxScore) {
                maxScore = score;
                earliestClosingHour = i;
            } 
        }

        return earliestClosingHour;
    }
}