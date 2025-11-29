class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int count =0;
        for(int n : nums ){
            sum+= n;
        }
        while(sum%k != 0){
          sum--;
          count++;
        }
        return count;
    }
}