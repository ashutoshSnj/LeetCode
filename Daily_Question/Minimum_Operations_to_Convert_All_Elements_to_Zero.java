package Daily_Question;

import java.util.ArrayDeque;
import java.util.Deque;

public class Minimum_Operations_to_Convert_All_Elements_to_Zero {

	  public int minOperations(int[] nums) {
	    int ans = 0;
	    Deque<Integer> stack = new ArrayDeque();
	    stack.push(0);

	    for (final int num : nums) {
	      while (!stack.isEmpty() && stack.peek() > num)
	        stack.pop();
	      if (stack.isEmpty() || stack.peek() < num) {
	        ++ans;
	        stack.push(num);
	      }
	    }

	    return ans;
	  }
	}