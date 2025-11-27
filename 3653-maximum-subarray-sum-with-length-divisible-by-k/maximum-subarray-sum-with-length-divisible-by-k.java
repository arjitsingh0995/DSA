class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0L;

        // min prefix sum for each remainder class
        long[] minPrefix = new long[k];
        // initialize with +infinity
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        // prefix[0] = 0 has remainder 0
        minPrefix[0] = 0L;

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];

            int r = (i + 1) % k; // prefix index is i+1

            if (minPrefix[r] != Long.MAX_VALUE) {
                // candidate subarray sum with length divisible by k
                ans = Math.max(ans, prefix - minPrefix[r]);
            }

            // update min prefix for current remainder (based on current prefix index i+1)
            minPrefix[(i + 1) % k] = Math.min(minPrefix[(i + 1) % k], prefix);
        }

        return ans;
    }
}
