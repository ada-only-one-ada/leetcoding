class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene)) return -1;
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        queue.add(new Pair(startGene, 0));
        Set<String> visited = new HashSet<>();
        char[] letters = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String gene = curr.getKey();
            int mutation = curr.getValue();

            if (gene.equals(endGene)) return mutation;
            if (visited.contains(gene)) continue;

            for (int i = 0; i < 8; i++) {
                StringBuilder newGene = new StringBuilder(gene);

                for (char c: letters) {
                    newGene.setCharAt(i, c);
                    if (set.contains(newGene.toString())) {
                        queue.add(new Pair(newGene.toString(), mutation + 1));
                    }
                }
            }

            visited.add(gene);
        }

        return -1;
    }
}