package Daily_Question;
import java.util.*;
public class Maximum_Number_of_Distinct_Elements_After_Operations {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long nextFree = Long.MIN_VALUE;
        int count = 0;
        
        for (int num : nums) {
            long start = (long) num - k;
            long end = (long) num + k;
            
            if (nextFree < start) nextFree = start;
            
            if (nextFree <= end) {
                count++;
                nextFree++; 
            }
        }
        return count;
    }

    public static void main(String[] args) {
    	Maximum_Number_of_Distinct_Elements_After_Operations sol = new Maximum_Number_of_Distinct_Elements_After_Operations();
        System.out.println(sol.maxDistinctElements(new int[]{1,2,2,3,3,4}, 2));
        System.out.println(sol.maxDistinctElements(new int[]{4,4,4,4}, 1));     
    }
}
