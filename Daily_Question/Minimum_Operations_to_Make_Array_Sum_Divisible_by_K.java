package Daily_Question;

import java.util.Arrays;

public class Minimum_Operations_to_Make_Array_Sum_Divisible_by_K {
	  public int minOperations(int[] nums, int k) {
	    return Arrays.stream(nums).sum() % k;
	  }
	}
