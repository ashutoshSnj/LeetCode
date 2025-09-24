package Daily_Question;
import java.util.HashMap;
public class Fraction_to_Recurring_Decimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
     
        sb.append(num / den);
        long rem = num % den;
        if (rem == 0) return sb.toString();
        
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        
        while (rem != 0) {
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }
        
        return sb.toString();
    }
}
