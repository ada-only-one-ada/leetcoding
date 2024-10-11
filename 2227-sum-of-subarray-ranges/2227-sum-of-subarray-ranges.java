public class Solution {
    public long solve(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];  // left[i] 存储左侧严格大于 nums[i] 的最近元素的索引（如果不存在则为 -1）
        int[] right = new int[n]; // right[i] 存储右侧大于等于 nums[i] 的最近元素的索引（如果不存在则为 n）
        for (int i = 0; i < n; i++) {
            right[i] = n;
        }
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[st.peek()] <= nums[i]) {
                right[st.peek()] = i;
                st.pop();
            }
            left[i] = st.peek();
            st.push(i);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        long ans = solve(nums);
        for (int i = 0; i < nums.length; i++) {  // 对所有元素取反，这样用相同的函数可以计算最小值的贡献
            nums[i] = -nums[i];
        }
        return ans + solve(nums);
    }
}
