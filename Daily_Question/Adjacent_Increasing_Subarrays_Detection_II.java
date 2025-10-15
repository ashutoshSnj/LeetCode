package Daily_Question;
import java.util.*;
public class Adjacent_Increasing_Subarrays_Detection_II {
    public int maxIncreasingSubarrays(List<Integer> numsList) {
        int n = numsList.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = numsList.get(i); 

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) left[i] = left[i - 1] + 1;
            else left[i] = 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) right[i] = right[i + 1] + 1;
            else right[i] = 1;
        }

        int maxK = 0;
        for (int i = 0; i < n - 1; i++) {
            maxK = Math.max(maxK, Math.min(left[i], right[i + 1]));
        }

        return maxK;
    }
}
