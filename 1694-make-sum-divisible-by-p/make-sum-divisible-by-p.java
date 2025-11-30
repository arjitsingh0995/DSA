class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0L;
        for (int x : nums) {
            sum += x;
        }
        int r = (int)(sum % p);
        if (r == 0) return 0;

        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1); // prefix before array starts

        int prefix = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {
            prefix = (int)((prefix + (long)nums[i]) % p);
            int need = (prefix - r + p) % p; // previous prefix we need

            if (last.containsKey(need)) {
                ans = Math.min(ans, i - last.get(need));
            }

            // store/overwrite the latest index for this prefix mod
            last.put(prefix, i);
        }

        // not allowed to remove whole array
        return ans == n ? -1 : ans;
    }
}
