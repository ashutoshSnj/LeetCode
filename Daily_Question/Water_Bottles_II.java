package Daily_Question;

public class Water_Bottles_II {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;
        int empty = 0;
        int totalDrunk = 0;

        while (full > 0) {
          
            totalDrunk += full;
            empty += full;
            full = 0;

            
            if (empty >= numExchange) {
                full = 1;
                empty -= numExchange;
                numExchange++; 
            }
        }

        return totalDrunk;
    }
}

