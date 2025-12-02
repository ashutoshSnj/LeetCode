package Daily_Question;
import java.util.*;
public class Count_Number_of_Trapezoids_I {
    private static final long MOD = 1_000_000_007L;
    public int countTrapezoids(int[][] points) {

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] p : points) {
            cnt.put(p[1], cnt.getOrDefault(p[1], 0) + 1);
        }

      
        ArrayList<Long> pairs = new ArrayList<>(cnt.size());
        for (int c : cnt.values()) {
            if (c >= 2) pairs.add((long)c * (c - 1) / 2);
        }

       
        if (pairs.size() < 2) return 0;

        long sum = 0L;
        long sumSq = 0L;
        for (long v : pairs) {
            sum = (sum + (v % MOD)) % MOD;
            sumSq = (sumSq + (v % MOD) * (v % MOD)) % MOD;
        }

        
        long total = ( ( (sum * sum) % MOD - sumSq + MOD ) % MOD );
        long inv2 = (MOD + 1) / 2; 
        total = (total * inv2) % MOD;

        return (int) total;
    }
}
