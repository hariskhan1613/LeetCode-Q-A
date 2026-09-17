class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return f(s, p, 0, 0, dp);
    }

    boolean f(String s, String p, int i, int j, Boolean[][] dp) {

        if (i == s.length() && j == p.length())
            return true;
        if (j == p.length())
            return false;
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = f(s, p, i + 1, j + 1, dp);
        } else if (p.charAt(j) == '*') {
            dp[i][j] = f(s, p, i + 1, j, dp) || f(s, p, i, j + 1, dp);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}
