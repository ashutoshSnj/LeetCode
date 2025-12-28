package Daily_Question;

public class Count_Negative_Numbers_in_a_Sorted_Matrix {

	  public int countNegatives(int[][] grid) {
	    final int m = grid.length;
	    final int n = grid[0].length;
	    int ans = 0;
	    int i = m - 1;
	    int j = 0;

	    while (i >= 0 && j < n) {
	      if (grid[i][j] < 0) {
	        ans += n - j;
	        --i;
	      } else {
	        ++j;
	      }
	    }

	    return ans;
	  }
	}