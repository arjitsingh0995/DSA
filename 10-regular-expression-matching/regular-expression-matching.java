class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0, memo);
    }

    private boolean match(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];
        if (j == p.length()) return memo[i][j] = (i == s.length());
        boolean first_match = (i < s.length()) &&
            (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        boolean ans;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two cases: zero or more of preceding element
            ans = match(s, p, i, j + 2, memo) ||
                  (first_match && match(s, p, i + 1, j, memo));
        } else {
            ans = first_match && match(s, p, i + 1, j + 1, memo);
        }
        return memo[i][j] = ans;
    }
}