package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class Binary_Prefix_Divisible_By_5 {
	  public List<Boolean> prefixesDivBy5(int[] nums) {
	    List<Boolean> ans = new ArrayList<>();
	    int curr = 0;

	    for (final int num : nums) {
	      curr = (curr * 2 + num) % 5;
	      ans.add(curr % 5 == 0);
	    }

	    return ans;
	  }
	}