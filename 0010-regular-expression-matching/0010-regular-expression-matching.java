class Solution {
    private String s, p;
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0);
    }

    private boolean dp(int i, int j) {
        // If pattern is exhausted, check if string is also exhausted
        if (j == p.length()) {
            return i == s.length();
        }
        if (memo[i][j] != null) return memo[i][j];

        boolean firstMatch = (i < s.length() && 
                              (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean result;
        // Check for `*` (must look ahead)
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Option 1: ignore the preceding char and '*' (match zero times)
            // Option 2: if firstMatch, use it and stay on the same pattern
            result = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
        } else {
            // Standard single character match
            result = firstMatch && dp(i + 1, j + 1);
        }

        memo[i][j] = result;
        return result;
    }
}