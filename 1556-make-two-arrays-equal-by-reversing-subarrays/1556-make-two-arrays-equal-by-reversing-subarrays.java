class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            int t = target[i];
            int a = arr[i];

            if (!freqMap.containsKey(t)) freqMap.put(t, 1);
            else freqMap.put(t, freqMap.get(t) + 1);
            
            if (!freqMap.containsKey(a)) freqMap.put(a, -1);
            else freqMap.put(a, freqMap.get(a) - 1);

            // [7], [7]
            // freqMap.putIfAbsent(t, freqMap.getOrDefault(t, 0) + 1);
            // freqMap.putIfAbsent(a, freqMap.getOrDefault(a, 0) - 1); 这一行没有执行 
            // putIfAbsent 方法的功能是，如果指定的键尚未与某个值相关联，则将其与给定值相关联。
            // 当 t 和 a 相同时，先为 t 执行的 putIfAbsent 方法会先将 t 的计数增加。
            // 紧接着，当执行到 a 的时候，由于 t 和 a 是相同的，a 已经在 Map 中存在了，因此 putIfAbsent 对于 a 什么也不会做。
        }

        for (int key: freqMap.keySet()) {
            if (freqMap.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
}