public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0; // 用于存储最终的结果，即那个只出现一次的元素
      
        for (int i = 0; i < 32; i++) { // 对每个位进行遍历，因为整数的位数是32位
            int sum = 0; // 用于计算在第 i 位的所有 1 的总和
            
            for (int num : nums) { // 遍历数组中的每个元素
                sum += (num >> i) & 1; // 将元素右移 i 位后，与 1 进行与操作，计算第 i 位是不是 1
            }
            res |= (sum % 3) << i; // 计算在所有元素中，第 i 位上1出现的次数除以3的余数，并将其左移 i 位后与结果进行或操作
        }
        return res; 
    }
}
