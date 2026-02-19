class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int n : nums){
            if(!st.add(n))return true;
        }
        return false;
    }
}