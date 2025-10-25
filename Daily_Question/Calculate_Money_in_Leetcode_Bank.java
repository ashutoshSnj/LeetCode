package Daily_Question;

public class Calculate_Money_in_Leetcode_Bank {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = (7 * weeks * (weeks + 1)) / 2 + 21 * weeks;
        total += (days * (2 * weeks + days + 1)) / 2;
        return total;
    }
}
