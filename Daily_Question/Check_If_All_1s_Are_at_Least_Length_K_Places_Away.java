package Daily_Question;

public class Check_If_All_1s_Are_at_Least_Length_K_Places_Away {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - prev <= k) return false;
                prev = i;
            }
        }
        return true;
    }
}
