class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pfs = new int[n] , pfe = new int[n], ans = new int[n];
        pfs[0]= nums[0];
        for(int i =1; i<n; i++){
            pfs[i]=pfs[i-1]*nums[i]; 
        }
        pfe[n-1]= nums[n-1];
        for(int i =n-2; i>0; i--){
            pfe[i]=pfe[i+1]*nums[i]; 
        }
        ans[0]=pfe[1];
        ans[n-1]=pfs[n-2];
        for(int i=1; i<n-1;i++)
        {
            ans[i]= pfs[i-1]*pfe[i+1];
        }
        return ans;
    }
}