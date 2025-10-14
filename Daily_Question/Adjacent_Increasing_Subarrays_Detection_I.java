package Daily_Question;
import java.util.*;

public class Adjacent_Increasing_Subarrays_Detection_I {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int a = 0; a + 2 * k <= n; a++) {
            if (isIncreasing(nums, a, a + k - 1) && isIncreasing(nums, a + k, a + 2 * k - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
