class Solution {
    public int longestOnes(int[] nums, int k) {
         int left = 0;
        int zeroCount = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Window invalid hai
            if (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Valid window ka maximum length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}