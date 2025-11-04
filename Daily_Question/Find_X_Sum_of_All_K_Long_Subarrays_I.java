package Daily_Question;
import java.util.*;

public class Find_X_Sum_of_All_K_Long_Subarrays_I {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : sub) freq.put(num, freq.getOrDefault(num, 0) + 1);

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
            list.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return b.getValue() - a.getValue();
                return b.getKey() - a.getKey();
            });

            Set<Integer> top = new HashSet<>();
            for (int j = 0; j < Math.min(x, list.size()); j++)
                top.add(list.get(j).getKey());

            int sum = 0;
            for (int num : sub)
                if (top.contains(num)) sum += num;

            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
    	
    	Find_X_Sum_of_All_K_Long_Subarrays_I s = new Find_X_Sum_of_All_K_Long_Subarrays_I();
        System.out.println(Arrays.toString(s.findXSum(new int[]{1,1,2,2,3,4,2,3}, 6, 2)));
        System.out.println(Arrays.toString(s.findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
    }
}
