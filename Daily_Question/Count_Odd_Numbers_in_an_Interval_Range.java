package Daily_Question;

public class Count_Odd_Numbers_in_an_Interval_Range {
    public int countOdds(int low, int high) {
       
      
        int oddsUpToHigh = (high + 1) >> 1;  // Right shift by 1 is equivalent to divide by 2
        int oddsBeforeLow = low >> 1;        // Count of odd numbers before low
      
        return oddsUpToHigh - oddsBeforeLow;
    }
}
