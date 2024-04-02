class Solution {
    /*
    根据树的定义，一个有效的树应该是完全连通的，即从任一节点出发都能到达图中的任意其他节点，同时它不包含任何环。
    这个算法的核心思想是通过两个关键条件来验证给定的图是否符合这一定义：
    1. 边的数量等于节点数减一：这是树的一个基本属性。一棵有n个节点的树应该恰好有n−1条边。这一条件是基于树是一个连通且无环的图的性质。
       每添加一个节点到树中，就需要添加一条边来连接这个节点，以保持树的连通性。
       如果边数多于n−1，则意味着图中存在环；如果边数少于n−1，则图不是完全连通的。
    2. 通过广度优先搜索（BFS）检查图的连通性：算法使用BFS从节点0开始遍历图，检查是否所有的节点都可以被访问到。
       这里使用了队列queue来进行BFS，并用一个集合visited记录已访问的节点，确保每个节点只被访问一次。
       通过这种方式，如果遍历过程中访问到了图中的所有节点，则表明图是连通的。
       同时，由于我们已经通过条件1保证了边的数量正确，这也就意味着图中没有环。
    */

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new HashSet<>());
            graph.putIfAbsent(to, new HashSet<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); 

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll(); // 拿到当前节点
                visited.add(node); // 标记访问
            
                Set<Integer> neighbors = graph.get(node); // 拿到邻节点们
                if (neighbors == null) continue;
                for (int nei: neighbors) {
                    if (visited.contains(nei)) continue; 
                    /* 为了跳过那些已经访问过的邻接节点，以避免重复访问
                       这是因为在无向图中，当我们考虑一个节点的所有邻接节点时，很自然地会再次遇到指向它的节点。这并不意味着图中存在环。
                       举个例子，如果我们有一条边连接节点A和节点B，当我们从A访问到B时，B的邻接节点中会包含A。
                       如果我们因为“回访”就认为存在环，那么几乎所有的无向图都会被错误地判定为包含环，这显然不符合我们的目的。
                       比如例子1，我们从0开始，设置0为访问过，然后可以访问到1，2，3。
                       接着1，可以访问到0，4，但这里访问过0，不是返回false。只是确保不再访问。
                       接着2，可以访问到0，
                       接着3，可以访问到0，
                       此时queue里剩下4，可以访问到1。
                       到这里5个nodes全部访问过了，是一棵树。
                    */
                    queue.add(nei);
                }
            }
        }

        return visited.size() == n;
    }
}