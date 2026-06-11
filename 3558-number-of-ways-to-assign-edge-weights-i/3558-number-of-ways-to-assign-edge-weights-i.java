class Solution {
    long MOD = 1000000007L;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(1, -1, 0, graph);

        return (int) power(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int depth,
                     List<Integer>[] graph) {

        maxDepth = Math.max(maxDepth, depth);

        for (int nei : graph[node]) {
            if (nei != parent) {
                dfs(nei, node, depth + 1, graph);
            }
        }
    }

    private long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}