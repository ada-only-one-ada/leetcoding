class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] words = text.split(" ");

        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                res.add(words[i]);
            }
        }

        String[] array = new String[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }
        
        return array;
    }
}