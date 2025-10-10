package Daily_Question;

public class Taking_Maximum_Energy_From_the_Mystic_Dungeon {
	    public int maximumEnergy(int[] energy, int k) {
	        int n = energy.length;
	        int ans = Integer.MIN_VALUE;

	        for (int i = n - 1; i >= 0; i--) {
	            if (i + k < n)
	                energy[i] += energy[i + k];
	            ans = Math.max(ans, energy[i]);
	        }

	        return ans;
	    }
	}
