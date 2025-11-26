class Solution {
    public int numberOfPaths(int[][] grid, int k) {
     int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][r] = number of paths to grid[i][j] with sum%k == r
        int[][][] dp = new int[m][n][k];

        // Initialize for the starting cell
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int r = 0; r < k; r++) {
                    int newR = (r + grid[i][j]) % k;

                    if (i > 0) {
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i - 1][j][r]) % MOD;
                    }
                    if (j > 0) {
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i][j - 1][r]) % MOD;
                    }
                }
            }
        }

        // Return count of paths where sum % k == 0
        return dp[m - 1][n - 1][0];   
    }
}