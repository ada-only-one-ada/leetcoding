class Solution {
    Set<Integer> set = new HashSet<>();

    public int distinctIntegers(int n) {
        set.add(n);
        for (int i = n; i > 0; i--) {
            if (n % i == 1 && !set.contains(i)) {
                set.add(i);
                return distinctIntegers(i);
            }
        }

        return set.size();
    }
}