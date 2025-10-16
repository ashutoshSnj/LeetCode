package Daily_Question;
import java.util.*;
public class Smallest_Missing_Non_negative_Integer_After_Operations {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        
     
        for (int num : nums) {
            int rem = ((num % value) + value) % value; 
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        
        int i = 0;
        while (true) {
            int rem = i % value;
            if (remainderCount.getOrDefault(rem, 0) == 0) {
                return i;
            }

            remainderCount.put(rem, remainderCount.get(rem) - 1);
            i++;
        }
    }
}

