package Daily_Question;

public class Greatest_Sum_Divisible_by_Three {
	  public int maxSumDivThree(int[] nums) {
	    int[] dp = new int[3];
	    for (final int num : nums)
	      for (final int sum : dp.clone())
	        dp[(sum + num) % 3] = Math.max(dp[(sum + num) % 3], sum + num);

	    return dp[0];
	  }
	}
