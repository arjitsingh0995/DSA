class Solution {
    public boolean isPalindrome(String s) {
       int left = 0;
       int right = (s.length()-1);
       while(left<right){
        while(left<right && !Character.isLetterOrDigit(s.charAt(left))) left++;
        while(left<right && !Character.isLetterOrDigit(s.charAt(right))) right--;
        if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;
       }       
       return true;






        //  String str = "";
        // for(int i =0; i<s.length(); i++){
        //     if(Character.isLetterOrDigit(s.charAt(i))) 
        //     str += Character.toLowerCase(s.charAt(i));
        // }
        // for(int i = 0; i<str.length(); i++){
        //     char c = str.charAt(i);
        //     if(!(c == str.charAt(str.length()-i-1))) return false;
        // }
        // return true;
    }
}