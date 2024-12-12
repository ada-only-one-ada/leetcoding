
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n > 0) {
            int newN = getSquare(n);
            if (visited.contains(newN)) return false;
            if (newN == 1) return true;
            visited.add(newN);
            n = newN;      
        }
        return false;
    }

    public int getSquare(int n) {   // time complexity is O(logn)
        int squared = 0;
        while (n != 0) {
            squared += (n % 10) * (n % 10);
            n = n / 10; 
        }

        return squared;
    }
}