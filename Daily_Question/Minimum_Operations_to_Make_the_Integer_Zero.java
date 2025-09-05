package Daily_Question;

public class Minimum_Operations_to_Make_the_Integer_Zero {

    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long target = (long) num1 - (long) k * num2; 
            if (target < 0) continue;
            int bits = Long.bitCount(target);
            if (bits <= k && k <= target) {
                return k; 
            }
        }
        return -1; 
    }
}
