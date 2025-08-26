package Daily_Question;

public class Maximum_Area_of_Longest_Diagonal_Rectangle {


    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];
            int diagonalSq =l*l+w*w;  
            int area = l * w;

            if (diagonalSq > maxDiagonal) {
                maxDiagonal = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
