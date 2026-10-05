class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder str = new StringBuilder(s);
         String str = "";
        for(int i =0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))) 
            str += Character.toLowerCase(s.charAt(i));
        }
        // s= str.toString();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!(c == str.charAt(str.length()-i-1))) return false;
        }
        return true;
    }
}