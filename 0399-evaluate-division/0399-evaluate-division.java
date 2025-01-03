class Solution {
    Map<String, Map<String, Double>> map = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            String num1 = equation.get(0);
            String num2 = equation.get(1);
            double value = values[i];

            map.putIfAbsent(num1, new HashMap<>());
            map.putIfAbsent(num2, new HashMap<>());

            map.get(num1).put(num2, value);
            map.get(num2).put(num1, 1 / value);

            map.get(num1).put(num1, 1.0);
            map.get(num2).put(num2, 1.0);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String queryNum1 = query.get(0);
            String queryNum2 = query.get(1);
            res[i] = dfs(queryNum1, queryNum2, 1.0, new HashSet<>());
        }

        return res;
    }

    public double dfs(String num1, String num2, double value, Set<String> set) {
        if (!map.containsKey(num1)) return -1.0;
        if (num1.equals(num2)) return value;
        if (set.contains(num1)) return -1.0;

        Map<String, Double> neighbors = map.get(num1);
        for (String next: neighbors.keySet()) {
            set.add(num1);
            double temp = dfs(next, num2, value * neighbors.get(next), set);
            if (temp != -1.0) {
                return temp;
            } 
            set.remove(num1);
        }
        

        return -1.0;
    }
}