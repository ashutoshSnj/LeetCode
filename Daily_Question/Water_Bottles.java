package Daily_Question;

public class Water_Bottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;  
            drunk += newBottles;              
            empty = empty - newBottles * numExchange + newBottles;
        }

        return drunk;
    }
}

