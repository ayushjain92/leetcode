public class LCS {

    // https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
    // https://leetcode.com/problems/longest-common-subsequence/description/
    public static void main(String[] args) {
        LCS lcs = new LCS();
        String x = "AGGTAB";
        String y = "GXTXAYB";
        int answer = lcs.longestCommonSubsequence(x, y);

        System.out.println(answer);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // Input : AGGTAB & GXTXAYB,
        // Output: 4 (LCS: GTAB)


        int n = text1.length();
        int m = text2.length();

        // recursion
        //return lcsUtilRecursive(text1, n-1, text2, m-1); // TLE

        // DP
        int table[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                table[i][j] = -1;
            }
        }
        return lcsUtilDP(text1, n, text2, m, table); // TLE
    }


    private int lcsUtilDP(String text1, int n, String text2, int m, int table[][]) { // arr.size
        //

        // base cases
        if (n < 1 || m < 1) {
            return 0;
        }

        if (table[n][m] != -1) {
            return table[n][m];
        }

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            table[n][m] = 1 + lcsUtilDP(text1, n - 1, text2, m - 1, table);
            return table[n][m];
        } else {
            table[n][m] = Math.max(lcsUtilDP(text1, n - 1, text2, m, table),
                    lcsUtilDP(text1, n, text2, m - 1, table));
            return table[n][m];
        }
    }

    private int lcsUtilRecursive(String text1, int n, String text2, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }


        if (text1.charAt(n) == text2.charAt(m)) {
            return 1 + lcsUtilRecursive(text1, n - 1, text2, m - 1);
        } else {
            return max(lcsUtilRecursive(text1, n - 1, text2, m), lcsUtilRecursive(text1, n, text2, m - 1));
        }
    }


    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
