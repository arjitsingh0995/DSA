class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        // Count how many points on each y
        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0) + 1);
        }

        long ans = 0L;
        long totalEdgesSoFar = 0L;

        // Iterate over all y-levels; order doesn't matter
        for (int count : freq.values()) {
            if (count >= 2) {
                long c = count;
                long currEdges = c * (c - 1) / 2 % MOD;   // C(c, 2)
                ans = (ans + currEdges * totalEdgesSoFar) % MOD;
                totalEdgesSoFar = (totalEdgesSoFar + currEdges) % MOD;
            }
        }

        return (int) ans;
    }
}
