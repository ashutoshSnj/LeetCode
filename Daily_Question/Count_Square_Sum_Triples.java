package Daily_Question;

import java.util.HashSet;
import java.util.Set;

public class Count_Square_Sum_Triples {
	  public int countTriples(int n) {
	    int ans = 0;
	    Set<Integer> squared = new HashSet<>();

	    for (int i = 1; i <= n; ++i)
	      squared.add(i * i);

	    for (final int a : squared)
	      for (final int b : squared)
	        if (squared.contains(a + b))
	          ++ans;

	    return ans;
	  }
	}