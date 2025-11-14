package Daily_Question;

public class Increment_Submatrice_by_One {

    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] diff = new int[n + 1][n + 1];

       
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            diff[r1][c1] += 1;

            if (c2 + 1 < n) 
                diff[r1][c2 + 1] -= 1;

            if (r2 + 1 < n) 
                diff[r2 + 1][c1] -= 1;

            if (r2 + 1 < n && c2 + 1 < n)
                diff[r2 + 1][c2 + 1] += 1;
        }

  
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // Step 3: Column-wise prefix sum
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

       
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = diff[i][j];
            }
        }

        return ans;
    }
}
