package Daily_Question;

public class Find_Triangular_Sum_of_an_Array {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; 
        }
        return nums[0];
    }
}
