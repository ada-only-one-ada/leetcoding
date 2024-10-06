class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split("\\s+");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            String[] subdomains = domain.split("\\.");

            String current = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                if (current.length() == 0) {
                    current = subdomains[i];
                } else {
                    current = subdomains[i] + "." + current;
                }
                map.put(current, map.getOrDefault(current, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }

        return result;
    }
}
