package Daily_Question;

public class Number_of_People_Aware_of_a_Secret {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1]; 
        dp[1] = 1; 
        long share = 0; 

        for (int day = 2; day <= n; day++) {
         
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
         
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
         
            dp[day] = share;
        }
        long result = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) {
                result = (result + dp[i]) % MOD;
            }
        }
        return (int) result;
    }
}
