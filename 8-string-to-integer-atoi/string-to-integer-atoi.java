class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())return 0;
        int i =0;
        long num =0 ; 
        int sign = 1;
        if(s.charAt(i)=='-'||s.charAt(i)=='+'){
        sign = s.charAt(i)=='-'? -1 : 1;
        i++;
        }
        int n = s.length();
        while(i<n && Character.isDigit(s.charAt(i))){
            num = num*10 + (s.charAt(i)-'0');
            if(num*sign > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            else if(num*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return  (int)num*sign ;
        // int i = 0;
        // int n = s.length();
        // int sign = 1;
        // int result = 0;

        // // Skip leading whitespace
        // while (i < n && s.charAt(i) == ' ') {
        //     i++;
        // }

        // // Check for sign
        // if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        //     sign = (s.charAt(i) == '-') ? -1 : 1;
        //     i++;
        // }

        // // Convert digits to integer, handling overflow
        // while (i < n && Character.isDigit(s.charAt(i))) {
        //     int digit = s.charAt(i) - '0';

        //     // Check for overflow
        //     if (result > (Integer.MAX_VALUE - digit) / 10) {
        //         return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //     }

        //     result = result * 10 + digit;
        //     i++;
        // }

        // return sign * result;

    }
}
