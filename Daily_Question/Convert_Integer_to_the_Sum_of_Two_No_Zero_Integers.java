package Daily_Question;

public class Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {


    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - a;

        while (!noZero(a) || !noZero(b)) {
            a++;
            b = n - a;
        }

        return new int[]{a, b};
    }

    
    private boolean noZero(int num) {
        while (num > 0) {
            int digit = num % 10; 
            if (digit == 0) {
                return false; 
            }
            num = num / 10;
        }
        return true;
    }
}
