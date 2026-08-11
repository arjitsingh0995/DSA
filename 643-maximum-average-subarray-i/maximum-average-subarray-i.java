class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int left = 0, sum = 0;
       double ans = -Double.MAX_VALUE, avg = 0;
       for(int right = 0 ; right < nums.length; right++ )
       {
         sum +=nums[right] ;
         if(right-left+1 == k){
            // avg = (double)sum/k ;
            ans = Math.max(ans,(double)sum/k);
            sum -= nums[left];
            left++;
        } 
       } 
       return ans ;
    }
}