package Daily_Question;

public class Number_of_Substrings_With_Only_1s {
    public int numSub(String s) {
        long count = 0, result = 0;
        long mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++; 
                result = (result + count) % mod;
            } else {
                count = 0; 
            }
        }

        return (int) result;
    }
}
