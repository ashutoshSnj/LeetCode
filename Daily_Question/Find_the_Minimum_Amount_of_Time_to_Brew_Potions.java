package Daily_Question;

public class Find_the_Minimum_Amount_of_Time_to_Brew_Potions {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        if (n == 0 || m == 0) return 0L;

       
        long[] prefPrev = new long[n];
        long cum = 0L;
        for (int i = 0; i < n; i++) {
            cum += (long) skill[i] * (long) mana[0];
            prefPrev[i] = cum;
        }

        long s = 0L; 
        for (int j = 1; j < m; j++) {
            long[] prefCurr = new long[n];
            cum = 0L;
            long L = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long pij = (long) skill[i] * (long) mana[j];
                cum += pij;
                prefCurr[i] = cum;
                long left = prefPrev[i];
                long right = (i == 0) ? 0L : prefCurr[i - 1];
                long val = left - right;
                if (val > L) L = val;
            }
            if (L < 0L) L = 0L;
            s += L;
            prefPrev = prefCurr;
        }

        return s + prefPrev[n - 1];
    }
}
