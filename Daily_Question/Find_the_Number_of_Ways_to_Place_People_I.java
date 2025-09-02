package Daily_Question;

public class Find_the_Number_of_Ways_to_Place_People_I {

    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int[] B = points[j];

              
                if (A[0] <= B[0] && A[1] >= B[1]) {
                    boolean valid = true;

              
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int[] P = points[k];
                        if (P[0] >= A[0] && P[0] <= B[0] &&
                            P[1] <= A[1] && P[1] >= B[1]) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
