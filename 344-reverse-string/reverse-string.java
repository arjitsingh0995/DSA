class Solution {
    public void reverseString(char[] s) {
       revString(s,0,s.length-1);
    }
    public void revString(char[] str, int low, int high)
    {
        if(low>=high)
        {
            return;
        }
        char temp = str[low];
        str[low] = str[high];
        str[high] = temp;
        revString(str, low+1, high-1);
    }
}