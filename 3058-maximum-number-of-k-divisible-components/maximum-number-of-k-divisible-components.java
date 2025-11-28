class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
              List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        long[] vals = new long[n];
        for (int i = 0; i < n; i++) vals[i] = values[i]; // avoid overflow
        int[] ans = new int[1]; // use array to mutate in dfs

        dfs(0, -1, g, vals, k, ans);
        return ans[0];
    }

    private long dfs(int u, int parent, List<Integer>[] g, long[] vals, int k, int[] ans) {
        long sum = vals[u] % k;

        for (int v : g[u]) {
            if (v == parent) continue;
            sum += dfs(v, u, g, vals, k, ans);
            sum %= k;
        }

        if (sum % k == 0) {
            ans[0]++;      // this subtree becomes a component
            return 0L;     // cut it off for parent
        }

        return sum; 
    }
}