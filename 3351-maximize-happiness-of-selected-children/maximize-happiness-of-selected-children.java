class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness); // sort ascending
        long ans = 0L;
        int n = happiness.length;
        // process from the largest values
        for (int i = 0; i < k; i++) {
            int idx = n - 1 - i;       // i-th largest element index
            long val = (long) happiness[idx] - i; // subtract decay
            if (val <= 0) break;       // nothing more to gain
            ans += val;
        }
        return ans;
    }
}
