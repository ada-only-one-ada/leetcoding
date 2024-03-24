class Solution {
    int totalNodes;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        totalNodes = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currRes = new ArrayList<>();
        currRes.add(0); //起点
        backtracking(graph, 0, res, currRes);
        return res;
    }

    public void backtracking(int[][] graph, int node, List<List<Integer>> res, List<Integer> currRes) {
        if (node == totalNodes - 1) {//走到了终点
            res.add(new ArrayList<>(currRes)); //找到了一条路线，加入结果
            return;
        }

        int[] nextNodes = graph[node];
        for (int i = 0; i < nextNodes.length; i++) {
            int nextNode = nextNodes[i]; //找到它下一个node
            currRes.add(nextNode); //加入当前路径
            backtracking(graph, nextNode, res, currRes); //再接着下一个的node去找
            currRes.remove(currRes.size() - 1); //回溯
        }
    }
}