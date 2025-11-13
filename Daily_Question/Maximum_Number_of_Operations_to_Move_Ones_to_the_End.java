package Daily_Question;

public class Maximum_Number_of_Operations_to_Move_Ones_to_the_End {
	  public int maxOperations(String s) {
	    int ans = 0;
	    int ones = 0;

	    for (int i = 0; i < s.length(); ++i)
	      if (s.charAt(i) == '1')
	        ++ones;
	      else if (i == s.length() - 1 || s.charAt(i + 1) == '1')
	        ans += ones;

	    return ans;
	  }
	}


