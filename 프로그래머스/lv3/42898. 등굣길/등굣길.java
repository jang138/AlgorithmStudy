import java.util.*;

class Solution {    
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
		int dp[][] = new int[n + 1][m + 1];

		for (int[] pud : puddles) {
			dp[pud[1]][pud[0]] = -1;
		}

		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}

				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i][j]) % mod;

			}
		}

		return dp[n][m] % mod;
    }
}