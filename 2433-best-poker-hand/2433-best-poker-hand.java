class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        // 1 <= ranks[i] <= 13, 'a' <= suits[i] <= 'd'
        int[] rankCount = new int[14];
        int[] suitCount = new int[5];
        
        int maxRank = 0;
        int maxSuit = 0;

        for (int i = 0; i < 5; i++) {
            int currRank = ranks[i];
            char currSuit = suits[i];

            rankCount[currRank]++;
            suitCount[currSuit - 'a']++;

            maxRank = Math.max(maxRank, rankCount[currRank]);
            maxSuit = Math.max(maxSuit, suitCount[currSuit - 'a']);
        }

        if (maxSuit == 5) {
            return "Flush";
        } else if (maxRank >= 3) {
            return "Three of a Kind";
        } else if (maxRank >= 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}