class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here
        if(n<=1)return 1;
        int fact = n*factorial(n-1);
        return fact;
    }
}
