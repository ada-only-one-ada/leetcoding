public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length() + "." + s);// 5.hello6.bye
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < s.length()) {
            int dotIndex = s.indexOf(".", i);
            int wordLen = Integer.valueOf(s.substring(i, dotIndex));
            String word = s.substring(dotIndex + 1, dotIndex + 1 + wordLen);
            res.add(word);
            i = dotIndex + wordLen+1;
        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));