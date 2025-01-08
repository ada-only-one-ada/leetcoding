class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s: bank) {
            bankSet.add(s);
        }
        if (startGene.equals(endGene)) return 0;
        if (!bankSet.contains(endGene)) return -1;

        Map<String, List<String>> map = new HashMap<>();
        buildGraph(map, bank, startGene);
        
        
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

    public void buildGraph(Map<String, List<String>> map, String[] bank, String startGene) {
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank.length; j++) {
                if (bank[i].equals(bank[j])) continue;
                if (bank[i].length() != bank[j].length()) continue;

                int diff = 0;
                for (int index = 0; index < bank[i].length(); index++) {
                    if (bank[i].charAt(index) != bank[j].charAt(index)) {
                        diff++;
                    }
                }

                if (diff == 1) {
                    map.putIfAbsent(bank[i], new ArrayList<>());
                    map.putIfAbsent(bank[j], new ArrayList<>());
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }

            for (int j = 0; j < startGene.length(); j++) {
                if (bank[i].length() != startGene.length()) continue;

                int diff = 0;
                for (int index = 0; index < bank[i].length(); index++) {
                    if (bank[i].charAt(index) != startGene.charAt(index)) {
                        diff++;
                    }
                }

                if (diff == 1) {
                    map.putIfAbsent(bank[i], new ArrayList<>());
                    map.putIfAbsent(startGene, new ArrayList<>());
                    map.get(bank[i]).add(startGene);
                    map.get(startGene).add(bank[i]);
                }
            }
        } 
    }
}