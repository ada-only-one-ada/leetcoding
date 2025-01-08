class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        Map<String, List<String>> map = new HashMap<>();
        map.put(startGene, new ArrayList<>());

        for (String s: bank) {
            map.putIfAbsent(s, new ArrayList<>());
            if (hasOneDiff(startGene, s)) {
                map.get(startGene).add(s);
                map.get(s).add(startGene);
            }
        }
        buildGraph(map, bank);

        if (!map.containsKey(endGene)) return -1;
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(startGene, 0));
        Set<String> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String gene = curr.getKey();
            int mutation = curr.getValue();

            if (gene.equals(endGene)) return mutation;
            if (set.contains(gene)) continue;

            if (map.get(gene) == null) continue;

            for (String nextGene: map.get(gene)) {
                queue.add(new Pair(nextGene, mutation + 1));
            }

            set.add(gene);
        }

        return -1;
    }

    public void buildGraph(Map<String, List<String>> map, String[] bank) {
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (i == j) continue;
                if (hasOneDiff(bank[i], bank[j])) {
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }
        } 
    }

    public boolean hasOneDiff(String gene1, String gene2) {
        if (gene1.equals(gene2) || gene1.length() != gene2.length()) return false;

        int diff = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                if (diff == 1) return false;
                diff++;
            }
        } 

        return true;
    }
}