public class CountDiceRolls {

    // https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
    public int numRollsToTarget(int n, int k, int target) {
        //return countRolls(n, k, target);
        return countRollsDP(n, k, target);
    }

    private int countRollsDP(int n, int k, int sum) {
        int[][] table = new int[n + 1][sum + 1];
        int mod = ((int) Math.pow(10, 9)) + 7;
        //Arrays.stream(table).forEach(a -> Arrays.fill(a, -1));

        table[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                for (int m = 1; m <= k; m++) {
                    if (m <= j) {
                        table[i][j] = (table[i][j] + table[i - 1][j - m]) % mod;
                    }
                }
            }
        }
        return table[n][sum];
    }

    private int countRolls(int n, int k, int sum) {
        int mod = ((int) Math.pow(10, 9)) + 7;

        //Recursion
        if (n <= 0) return 0;
        if (n == 1) return sum <= k ? 1 : 0;

        //System.out.println(mod);
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += (countRolls(n - 1, k, sum - i) % mod);
            ans = ans % mod;
        }

        return ans;

    }
}
