class Solution {
    public int numTeams(int[] rating) {
        /*
        递增 或者 递减
        【1，2，3，4】：
        递增：
        【1，2，3】，【1，2，4】，【1，3，4】
        【2，3，4】

        【2，5，3，4，1】
        递增：
        【2，3，4】
        递减：
        【5，3，1】，【5，4，1】

        大：
        2:【5，3，4】
        5:【】
        3:【4】
        4:【】
        1:【】

        小 
        2:【1】
        5:【3，4，1】
        3:【1】
        4:【1】
        1:【】
        */

        Map<Integer, Set<Integer>> smallMap = new HashMap<>();
        Map<Integer, Set<Integer>> bigMap = new HashMap<>();

        for (int i = 0; i < rating.length - 1; i++) {
            smallMap.put(rating[i], new HashSet<>());
            bigMap.put(rating[i], new HashSet<>());

            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) smallMap.get(rating[i]).add(rating[j]);
                if (rating[j] > rating[i]) bigMap.get(rating[i]).add(rating[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            Set<Integer> smallNeibors = smallMap.get(rating[i]);
            if (smallNeibors != null) {
                for (int s: smallNeibors) {
                    if (smallMap.get(s) != null) {
                        res += smallMap.get(s).size();
                    }
                }
            }
            
            Set<Integer> bigNeibors = bigMap.get(rating[i]);
            if (bigNeibors != null) {
                for (int b: bigNeibors) {
                    if (bigMap.get(b) != null) {
                        res += bigMap.get(b).size();
                    }
                }
            }
        }

        return res;
    }
}