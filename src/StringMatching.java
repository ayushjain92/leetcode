import java.util.Arrays;

public class StringMatching {
    public boolean isMatch(String s, String p) {
        //return countMatch(s, p, 0, 0);
        int[][] table = new int[s.length()][p.length()];
        //Arrays.stream(table).forEach(a -> a.fill(a, -1));
        Arrays.stream(table).forEach(a -> Arrays.fill(a, -1));

        return countMatchDP(s, p, 0, 0, table) == 1;
    }

    // a*b
    // ab or aab

    private int countMatchDP(String s, String p, int i, int j, int[][] table) {
        if (i == s.length() && j == p.length()) {
            return 1; // both at end
        }

        if (i < s.length() && j < p.length()) {
            if (table[i][j] != -1) {
                return table[i][j];
            }
        }

        if (i == s.length()) {
            // string at end // matcher remains
            if (p.charAt(j) == '*') {
                return countMatchDP(s, p, i, j + 1, table);
                //table[i][j] = countMatchDP(s, p, i, j+1, table);
                //return table[i][j];
            }

            //return false;
            //table[i][j] = 0;
            return 0;//table[i][j];
        }

        if (j == p.length()) {
            // matcher at end // string remains
            //return false;
            return 0;
        }

        if (s.charAt(i) == p.charAt(j)) {
            //return countMatch(s, p, i+1, j+1);
            table[i][j] = countMatchDP(s, p, i + 1, j + 1, table);
            return table[i][j];
        } else if (p.charAt(j) == '?') {
            table[i][j] = countMatchDP(s, p, i + 1, j + 1, table);
            return table[i][j];
        } else if (p.charAt(j) == '*') {
            //return countMatch(s, p, i, j+1) || countMatch(s, p, i+1, j);

            if (countMatchDP(s, p, i, j + 1, table) == 1 || countMatchDP(s, p, i + 1, j, table) == 1) {
                table[i][j] = 1;
            } else {
                table[i][j] = 0;
            }
            return table[i][j];
        } else {
            //return false;
            table[i][j] = 0;
            return table[i][j];
        }
    }


    // a*b?c
    // aaaabkc - true
    // aaabbkc - true
    // aaaabckc - false
    private boolean countMatch(String s, String p, int i, int j) {


        if (i == s.length() && j == p.length()) {
            return true; // both at end
        }

        if (i == s.length()) {
            // string at end // matcher remains
            while (p.charAt(j) == '*') {
                j++;
                if (j == p.length()) {
                    return true;
                }
            }

            return false;
        }

        if (j == p.length()) {
            // matcher at end // string remains
            return false;
        }

        if (s.charAt(i) == p.charAt(j)) {
            return countMatch(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '?') {
            return countMatch(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            return countMatch(s, p, i, j + 1) || countMatch(s, p, i + 1, j);
        } else {
            return false;
        }
    }
}
