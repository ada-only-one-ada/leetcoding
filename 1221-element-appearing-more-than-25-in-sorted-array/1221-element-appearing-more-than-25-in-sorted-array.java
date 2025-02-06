class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > arr.length / 4) {
                return num;
            }
        }

        return -1;
    }
}