package Daily_Question;

public class Minimum_Operations_to_Make_Array_Elements_Zero {

    public long minOperations(int[][] queries) {
       
        long[] limits = new long[20];
        limits[0] = 0;
        for (int i = 1; i < 20; i++) {
            limits[i] = (1L << (2 * i)) - 1; 
        }

        long totalAns = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long stepsSum = 0;

            for (int k = 1; k < 20; k++) {
                long left = Math.max(l, limits[k - 1] + 1);
                long right = Math.min(r, limits[k]);
                if (left <= right) {
                    long cnt = right - left + 1;
                    stepsSum += cnt * k;
                }
            }

            totalAns += (stepsSum + 1) / 2;
        }
        return totalAns;
    }
}
