package Daily_Question;
import java.util.*;

public class Successful_Pairs_of_Spells_and_Potions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            int left = 0, right = m - 1;
            int idx = m;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (spell * potions[mid] >= success) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = m - idx;
        }

        return result;
    }

    public static void main(String[] args) {
    	Successful_Pairs_of_Spells_and_Potions  s = new Successful_Pairs_of_Spells_and_Potions ();
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        long success1 = 7;
        System.out.println(Arrays.toString(s.successfulPairs(spells1, potions1, success1)));

        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        long success2 = 16;
        System.out.println(Arrays.toString(s.successfulPairs(spells2, potions2, success2)));
    }
}
