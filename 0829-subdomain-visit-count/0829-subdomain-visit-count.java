class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int count = Integer.valueOf(s[0]);
            String[] parts = s[1].split("\\.");
            String sub = "";

            for (int i = parts.length - 1; i >= 0; i--) {
                String curr;
                if (sub.length() == 0) {
                    curr = parts[i];
                } else {
                    curr = parts[i] + "." + sub;
                }

                map.put(curr, map.getOrDefault(curr, 0) + count);
                sub = parts[i] + (i != parts.length - 1? "." : "") + sub;  
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}
