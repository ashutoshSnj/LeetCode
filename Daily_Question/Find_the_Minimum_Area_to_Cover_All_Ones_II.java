package Daily_Question;

public class Find_the_Minimum_Area_to_Cover_All_Ones_II {

    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
                pref[i + 1][j + 1] = pref[i][j + 1] + rowSum;
            }
        }


        java.util.function.BiFunction<int[], int[], Integer> ones = (tl, br) -> {
            int r1 = tl[0], c1 = tl[1], r2 = br[0], c2 = br[1];
            return pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
        };

     
        java.util.function.BiFunction<int[], int[], Integer> area = (tl, br) -> {
            int r1 = tl[0], c1 = tl[1], r2 = br[0], c2 = br[1];
            if (ones.apply(tl, br) == 0) return Integer.MAX_VALUE;
            int minR = r2, maxR = r1, minC = c2, maxC = c1;
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (grid[i][j] == 1) {
                        if (i < minR) minR = i;
                        if (i > maxR) maxR = i;
                        if (j < minC) minC = j;
                        if (j > maxC) maxC = j;
                    }
                }
            }
            return (maxR - minR + 1) * (maxC - minC + 1);
        };

        int INF = Integer.MAX_VALUE, ans = INF;

      
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a = area.apply(new int[]{0, 0}, new int[]{m - 1, c1});
                int b = area.apply(new int[]{0, c1 + 1}, new int[]{m - 1, c2});
                int c = area.apply(new int[]{0, c2 + 1}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);
            }
        }

    
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a = area.apply(new int[]{0, 0}, new int[]{r1, n - 1});
                int b = area.apply(new int[]{r1 + 1, 0}, new int[]{r2, n - 1});
                int c = area.apply(new int[]{r2 + 1, 0}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);
            }
        }

        for (int col = 0; col < n - 1; col++) {
            for (int row = 0; row < m - 1; row++) {
               
                int a = area.apply(new int[]{0, 0}, new int[]{m - 1, col});
                int b = area.apply(new int[]{0, col + 1}, new int[]{row, n - 1});
                int c = area.apply(new int[]{row + 1, col + 1}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);

                a = area.apply(new int[]{0, 0}, new int[]{row, col});
                b = area.apply(new int[]{row + 1, 0}, new int[]{m - 1, col});
                c = area.apply(new int[]{0, col + 1}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);
            }
        }

        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
    
                int a = area.apply(new int[]{0, 0}, new int[]{row, n - 1});
                int b = area.apply(new int[]{row + 1, 0}, new int[]{m - 1, col});
                int c = area.apply(new int[]{row + 1, col + 1}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);

        
                a = area.apply(new int[]{0, 0}, new int[]{row, col});
                b = area.apply(new int[]{0, col + 1}, new int[]{row, n - 1});
                c = area.apply(new int[]{row + 1, 0}, new int[]{m - 1, n - 1});
                if (a < INF && b < INF && c < INF) ans = Math.min(ans, a + b + c);
            }
        }

        return ans;
    }
}
