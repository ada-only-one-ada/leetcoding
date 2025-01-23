class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int amount = citations.length - i;

            if (citations[i] >= amount) {
                return amount;
            }
        }

        return 0;
    }
}