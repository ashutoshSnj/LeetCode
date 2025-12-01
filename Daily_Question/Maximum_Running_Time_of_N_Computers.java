package Daily_Question;

import java.util.Arrays;

public class Maximum_Running_Time_of_N_Computers {

	  public long maxRunTime(int n, int[] batteries) {
	    long sum = Arrays.stream(batteries).asLongStream().sum();

	    Arrays.sort(batteries);

	    int i = batteries.length - 1;
	    while (batteries[i] > sum / n) {
	      sum -= batteries[i--];
	      --n;
	    }
	    return sum / n;
	  }
	}