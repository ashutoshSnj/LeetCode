package Daily_Question;
import java.util.*;
public class Maximum_Total_Damage_With_Spell_Casting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        List<Integer> unique = new ArrayList<>(map.keySet());
        Collections.sort(unique);

        int n = unique.size();
        long[] dp = new long[n];
        dp[0] = map.get(unique.get(0));

        for (int i = 1; i < n; i++) {
            long take = map.get(unique.get(i));
            int j = i - 1;
            while (j >= 0 && unique.get(i) - unique.get(j) <= 2) j--;
            if (j >= 0) take += dp[j];

            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }
}
