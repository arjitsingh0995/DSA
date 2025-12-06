class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        final int MOD = 1_000_000_007;

        long[] dp = new long[n];
        long[] pre = new long[n];  // prefix sums of dp

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0;

        for (int i = 0; i < n; i++) {
            // maintain max deque (indices, values decreasing)
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[i]) {
                maxD.pollLast();
            }
            maxD.offerLast(i);

            // maintain min deque (indices, values increasing)
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[i]) {
                minD.pollLast();
            }
            minD.offerLast(i);

            // shrink window from left until max - min <= k
            while (!maxD.isEmpty() && !minD.isEmpty()
                    && (long) nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (maxD.peekFirst() == l) maxD.pollFirst();
                if (minD.peekFirst() == l) minD.pollFirst();
                l++;
            }

            // compute dp[i]
            if (l == 0) {
                long sumPrev = (i > 0) ? pre[i - 1] : 0;
                dp[i] = (sumPrev + 1) % MOD; // +1 for dp[-1]
            } else {
                long leftSum = pre[i - 1];
                long subtract = (l - 2 >= 0) ? pre[l - 2] : 0;
                dp[i] = (leftSum - subtract) % MOD;
                if (dp[i] < 0) dp[i] += MOD;
            }

            // update prefix sum
            pre[i] = dp[i];
            if (i > 0) {
                pre[i] = (pre[i] + pre[i - 1]) % MOD;
            }
        }

        return (int) dp[n - 1];
    }
}
