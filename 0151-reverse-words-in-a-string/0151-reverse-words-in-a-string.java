class Solution {
    public String reverseWords(String s) {
        char[] words = s.toCharArray();

        int i = 0; 
        while (i < words.length && words[i] == ' ') i++;
        
        int j = words.length - 1;
        while (j >= 0 && words[j] == ' ') j--;

        reverse(words, i, j);

        int left = i;
        for (int right = i; right <= j; right++) {
            if (words[right] == ' ') {
                reverse(words, left, right - 1);
                left = right + 1;
                while (left <= j && words[left] == ' ') left++;
            }
        }

        reverse(words, left, j);

        StringBuilder res = new StringBuilder();
        for (int index = i; index <= j; index++) {
            if (index > 0 && words[index] == ' ' && words[index-1] == ' ') continue;
            res.append(words[index]);
        }

        return res.toString();
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}