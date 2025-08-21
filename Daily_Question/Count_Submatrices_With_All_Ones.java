package Daily_Question;


public class Count_Submatrices_With_All_Ones{
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        int total = 0;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            total += countFromHistogram(heights);
        }
        
        return total;
    }
    
    private int countFromHistogram(int[] heights) {
        int n = heights.length;
        int count = 0;
        for (int j = 0;j < n; j++) {
            int minHeight = heights[j];
            for (int k = j; k >= 0 && minHeight > 0; k--) {
                minHeight = Math.min(minHeight, heights[k]);
                count += minHeight;
            }
        }
        return count;
    }
}
