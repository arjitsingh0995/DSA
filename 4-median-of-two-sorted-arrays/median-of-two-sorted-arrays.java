class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0, j=0, k=0;
        int n = nums1.length + nums2.length;
        int[] sorted = new int[n];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]) {
                sorted[k++] = nums1[i];
                i++;
            }
            else{
                sorted[k++] = nums2[j];
                j++;
            }
        }
        while(i<nums1.length){
            sorted[k++] = nums1[i++];
        }
        while(j<nums2.length){
            sorted[k++] = nums2[j++];
        }
        double res;
        if(n%2!=0) res = sorted[n/2];
        else res = (sorted[n/2]+sorted[n/2-1])/2.0;
        return res;
    }
}