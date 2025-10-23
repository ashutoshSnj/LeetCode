package Daily_Question;

public class Check_If_Digits_Are_Equal_in_String_After_Operations_I {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int sum = (a + b) % 10;
                newStr.append(sum);
            }
            s = newStr.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
