class Node {
    String num2;
    double value;

    Node(String num2, double value) {
        this.num2 = num2;
        this.value = value;
    }
}

class Solution {
    Map<String, List<Node>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {        
        for (int i = 0; i < equations.size(); i++) { 
            List<String> equation = equations.get(i);
            String num1 = equation.get(0);
            String num2 = equation.get(1);
            double value = values[i];

            map.putIfAbsent(num1, new ArrayList<>());
            map.putIfAbsent(num2, new ArrayList<>());

            map.get(num1).add(new Node(num2, value));
            map.get(num2).add(new Node(num1, 1 / value)); // a/b = 5, b/a = 1/5
        }

        double[] res = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String queryNum1 = query.get(0);
            String queryNum2 = query.get(1);

            res[i] = dfs(queryNum1, queryNum2, 1, map, new HashSet<>());
        }

        return res;
    }

    public double dfs(String startDividend, String endDivisor, double value, Map<String, List<Node>> map, HashSet<String> set) {
        if (!map.containsKey(startDividend)) return -1;
        if (set.contains(startDividend)) return -1;
        if (startDividend.equals(endDivisor)) return value;
        
        set.add(startDividend);
        for (Node node: map.get(startDividend)) {
            double res = dfs(node.num2, endDivisor, value * node.value, map, set); 
            if (res != -1) {
                return res;
            }
        }
        set.remove(startDividend);
      
       return -1.0;
    }
}