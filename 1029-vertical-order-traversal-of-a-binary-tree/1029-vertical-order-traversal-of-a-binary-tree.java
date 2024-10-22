class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair(root, new Pair(0, 0)));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> qValue = queue.poll();
            TreeNode curr = qValue.getKey();
            int y = qValue.getValue().getKey(); 
            int x = qValue.getValue().getValue(); 

            map.computeIfAbsent(y, k -> new TreeMap<>())    
                    .computeIfAbsent(x, k -> new ArrayList<>()) 
                    .add(curr.val);
            if (curr.left != null) {
                queue.add(new Pair(curr.left, new Pair(y - 1, x + 1)));  
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, new Pair(y + 1, x + 1)));
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> data : map.entrySet()) {
            Integer key = data.getKey();       
            List<Integer> dummy = new ArrayList<>(); 
            for(var x : map.get(key).keySet()){
                List<Integer> integers = map.get(key).get(x);   
                Collections.sort(integers);   
                dummy.addAll(integers);       
            }
            answer.add(dummy);                
        }

        return answer;  
    }
}