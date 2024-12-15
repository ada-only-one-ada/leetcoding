class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int left = 0;
        int right = arr.length - 1;
     
        while (left < right) {
            String temp = arr[left].trim();
            arr[left] = arr[right].trim();
            arr[right] = temp;
            left++;
            right--;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i != arr.length - 1) res.append(" ");
        }

        return res.toString();
    }
}