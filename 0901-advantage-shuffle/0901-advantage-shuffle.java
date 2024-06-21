class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int min = map.firstKey();
            int max = map.lastKey();

            
                Integer smallestGreater = map.higherKey(nums2[i]);
                if (smallestGreater != null) {
                    res[i] = smallestGreater;
                    map.put(smallestGreater, map.get(smallestGreater) - 1);
                    if (map.get(smallestGreater) == 0) {
                        map.remove(smallestGreater);
                    }
                } else {
                    res[i] = min;
                    map.put(min, map.get(min) - 1);
                    if (map.get(min) == 0) {
                        map.remove(min);
                    }
                }
            
        }

        return res;
    }
}