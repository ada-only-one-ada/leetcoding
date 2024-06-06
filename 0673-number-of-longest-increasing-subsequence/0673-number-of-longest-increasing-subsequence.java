class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] lens = new int[nums.length]; // lens[i]，以i结尾的，最少子序列的长度是多少
        int[] counts = new int[nums.length]; // counts[i]，以i结尾的，长度等于全局maxLen的子序列有多少个

        Arrays.fill(lens, 1); // 最短长度是1，即它自己本身
        Arrays.fill(counts, 1); // 至少有一个，就是它自己
        int maxLen = 1; // 初始最长长度为1

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { 
                    if (lens[j] + 1 == lens[i]) { // 如果这个j跟i也组成了以i结尾的最长长度，那么这个i可以跟所有的j搭配
                        counts[i] += counts[j]; // 加上跟j的搭配
                    } else if (lens[j] + 1 > lens[i]) { // 如果这个j跟i组成了以i结尾的更大的最长长度，那么i就只跟j搭配
                        lens[i] = lens[j] + 1; // 更新最长长度
                        counts[i] = counts[j]; // 只有跟j的搭配
                    }
                } 
            }
            maxLen = Math.max(maxLen, lens[i]); // 维护一个全局的maxLen
        }

        int count = 0;
        for (int i = 0; i < lens.length; i++) { 
            if (lens[i] == maxLen) { // 遍历长度array，一旦以i结尾的是最长长度
                count += counts[i]; // 加上i的counts
            }
        }
        return count;
    }
}