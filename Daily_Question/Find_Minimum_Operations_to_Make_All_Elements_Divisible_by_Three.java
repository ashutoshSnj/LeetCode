package Daily_Question;

import java.util.Arrays;

public class Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {
	  public int minimumOperations(int[] nums) {
	    return (int) Arrays.stream(nums).filter(num -> num % 3 != 0).count();
	  }
	}