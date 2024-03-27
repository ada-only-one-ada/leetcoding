class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] letters = {'A', 'C', 'G', 'T'};

        Set<String> remainingGene = new HashSet<>(Arrays.asList(bank));
        if (remainingGene.isEmpty() || !remainingGene.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currGene = queue.poll();
                if (currGene.equals(endGene)) {
                    return level;
                }

                for (int replaceIndex = 0; replaceIndex < currGene.length(); replaceIndex++) {
                    for (char letter: letters) {
                        String newGene = currGene.substring(0, replaceIndex) + letter + currGene.substring(replaceIndex + 1);

                        if (remainingGene.contains(newGene)) {
                            queue.add(newGene);
                            remainingGene.remove(newGene);
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }
}