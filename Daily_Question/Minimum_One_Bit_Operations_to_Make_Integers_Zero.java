package Daily_Question;

public class Minimum_One_Bit_Operations_to_Make_Integers_Zero {
	  public int minimumOneBitOperations(int n) {
	    if (n == 0)
	      return 0;
	   
	    int x = 1;
	    while (x * 2 <= n)
	      x <<= 1;
	    return minimumOneBitOperations(n ^ (x | x >> 1)) + 1 + x - 1;
	  }
	}