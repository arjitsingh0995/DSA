class Solution {
    static final long MOD = 1_000_000_007L;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        // Check if every other computer has strictly greater complexity than computer 0
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        // Compute (n - 1)! % MOD
        long fact = 1L;
        for (int i = 1; i <= n - 1; i++) {
            fact = (fact * i) % MOD;
        }
        return (int) fact;
    }
}
