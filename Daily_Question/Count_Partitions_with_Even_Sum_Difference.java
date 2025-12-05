package Daily_Question;

import java.util.Arrays;

public class Count_Partitions_with_Even_Sum_Difference {
	  public int countPartitions(int[] nums) {
	  
	    return Arrays.stream(nums).sum() % 2 == 0 ? nums.length - 1 : 0;
	  }
	}