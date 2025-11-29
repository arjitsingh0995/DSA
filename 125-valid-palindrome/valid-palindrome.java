class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        // String news = s.replaceAll("[^a-zA-Z0-9]", "");
        int first = 0;
        int last = s.length()-1;
        while(first<=last)
        {
            if(s.charAt(first)!=s.charAt(last))return false;
            first++;
            last--;

        }
        return true;
    }
}