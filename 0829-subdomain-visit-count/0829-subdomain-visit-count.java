class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
       
        for (String cpdomain: cpdomains) {
            String[] parts = cpdomain.split(" ");
         
            int rep = Integer.valueOf(parts[0]);
            String[] domains = parts[1].split("\\.");

            String suffix = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                if (i < domains.length - 1) {
                    suffix = domains[i] + "." + suffix;
                } else {
                    suffix = domains[i];
                }

                map.put(suffix, map.getOrDefault(suffix, 0) + rep);
            }
        }

        for (String key: map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}