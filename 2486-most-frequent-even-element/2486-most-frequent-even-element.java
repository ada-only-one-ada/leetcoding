class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001];
        for (int num: nums) {
            freq[num]++;
        }

        int maxFreq = 0;
        int even = -1;
        for (int i = 100000; i >= 0; i--) {
            if (freq[i] == 0) continue;
            if (freq[i] >= maxFreq && i % 2 == 0) {
                maxFreq = freq[i];
                even = i;
            } 
        }

        return even;
    }
}