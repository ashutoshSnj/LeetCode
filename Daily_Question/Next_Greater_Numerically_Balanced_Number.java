package Daily_Question;

public class Next_Greater_Numerically_Balanced_Number {

    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        
        while (true) {
            if (isBalanced(num)) {
                return num;
            }
            num++;
        }
    }

    private boolean isBalanced(int num) {
        String s = String.valueOf(num);
        int[] freq = new int[10];
        
        for (char c : s.toCharArray()) {
            int d = c - '0';
            freq[d]++;
        }
        
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (freq[d] != d) return false;
        }
        
        return freq[0] == 0;  
    }
}
