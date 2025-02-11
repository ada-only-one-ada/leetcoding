class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int target = nums[i] - k;
            
            if (map.containsKey(target)){
                if (map.get(target) != -1){ 
                    res++;
                    map.put(target, -1);
                }
            }
            //注意这里，如果之前的数字是1，已经用完了，当前数字也是1，就要也是设置成-1
            map.put(nums[i], map.getOrDefault(nums[i], 0));
            
            /*
            map.put(nums[i], 0);
            nums=[1,1,1,1,1], k=0. output:4, expected:1
            */
        }

        return res;
    }
}