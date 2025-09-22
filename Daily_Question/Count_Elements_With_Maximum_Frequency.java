package Daily_Question;

import java.util.HashMap;
import java.util.Map;
public class Count_Elements_With_Maximum_Frequency {
	

	public class MaxFrequencyElements {

	    public static int maxFrequencyElements(int[] nums) {
	        Map<Integer, Integer> freqMap = new HashMap<>();

	   
	        for (int num : nums) {
	            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
	        }

	      
	        int maxFreq = 0;
	        for (int count : freqMap.values()) {
	            if (count > maxFreq) {
	                maxFreq = count;
	            }
	        }

	    
	        int total = 0;
	        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
	            if (entry.getValue() == maxFreq) {
	                total += entry.getValue();
	            }
	        }

	        return total;
	    }

	    public static void main(String[] args) {
	        int[] nums1 = {1, 2, 2, 3, 1, 4};
	        int[] nums2 = {1, 2, 3, 4, 5};

	        System.out.println(maxFrequencyElements(nums1)); 
	        System.out.println(maxFrequencyElements(nums2)); 
	    }
	}
}
