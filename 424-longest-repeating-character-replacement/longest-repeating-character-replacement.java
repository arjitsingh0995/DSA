class Solution {
    public int characterReplacement(String s, int k) {
         int low = 0;
        int maxFreq = 0;
        int ans = 0;

        int[] freq = new int[26];

        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            while ((high - low + 1) - maxFreq > k) {

                freq[s.charAt(low) - 'A']--;

                low++;
            }

            ans = Math.max(ans, high - low + 1);
        }

        return ans;
        // int low = 0;
        // int curr = 0;
        // int max = 0;
        // int c = k;
        // for(int high =0 ;high<s.length(); high++ ){
        //     char ch = s.charAt(high);
        //     if(ch != s.charAt(low) && c!= 0)
        //     {
        //         ch = s.charAt(low);
        //         c--;
        //     }
        //         if(c==0){
        //         curr = high-low+1;
        //         max = Math.max(max, curr);
        //         low = high;
        //         c=k;
        //     }
        // }
        // return max;
    }
}