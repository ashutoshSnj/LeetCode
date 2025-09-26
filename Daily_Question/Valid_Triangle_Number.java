package Daily_Question;
import java.util.Arrays;

public class Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int count = 0;


        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
       
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
    	Valid_Triangle_Number sol = new Valid_Triangle_Number ();

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(sol.triangleNumber(nums1)); 

        int[] nums2 = {4, 2, 3, 4};
        System.out.println(sol.triangleNumber(nums2)); 
    }
}
