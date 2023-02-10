public class EditDistance {
        // https://leetcode.com/problems/edit-distance/description/
        static final int I = 1;
        static final int D = 1;
        static final int R = 1;

        public int minDistance(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();

            //return countMinDistance(word1, word2, n, m);
            return countMinDistanceDP(word1, word2, n, m);
        }

        private int countMinDistanceDP(String word1, String word2, int n, int m) {
            int[][] table = new int[n+1][m+1];
            table[0][0] = 0;
            for(int i=0; i<=n; i++) {
                table[i][0] = i*D;
            }

            for(int i=0; i<=m; i++) {
                table[0][i] = i*I;
            }

            for (int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++) {
                    table[i][j] = Math.min(
                            Math.min(table[i-1][j] + D, table[i][j-1] + I ),
                            table[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1))? 0: R)
                    );
                }
            }
            return table[n][m];
        }

        private int countMinDistance(String word1, String word2, int n, int m) {
            if(n==0 && m==0) {
                return 0;
            } else if(n == 0) {
                return m * I;
            } else if(m == 0) {
                return n * D;
            }

            return Math.min(
                    Math.min(
                            countMinDistance(word1, word2, n-1, m) + D,
                            countMinDistance(word1, word2, n, m-1) + I
                    ),
                    countMinDistance(word1, word2, n-1, m-1) +
                            ((word1.charAt(n-1) == word2.charAt(m-1))? 0 : R)
            );
        }
}
