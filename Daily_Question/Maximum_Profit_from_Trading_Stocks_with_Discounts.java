package Daily_Question;

public class Maximum_Profit_from_Trading_Stocks_with_Discounts {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int numItems = present.length;
        int[][] dp = new int[numItems + 1][budget + 1];

        for (int itemIndex = 1; itemIndex <= numItems; itemIndex++) {
            for (int currentBudget = 0; currentBudget <= budget; currentBudget++) {
                dp[itemIndex][currentBudget] = dp[itemIndex - 1][currentBudget];

                int currentItemCost = present[itemIndex - 1];
                if (currentBudget >= currentItemCost) {
                    int profitFromCurrentItem = future[itemIndex - 1] - present[itemIndex - 1];
                    int totalProfitWithCurrentItem =
                            dp[itemIndex - 1][currentBudget - currentItemCost] + profitFromCurrentItem;

                    dp[itemIndex][currentBudget] = Math.max(
                            dp[itemIndex][currentBudget],
                            totalProfitWithCurrentItem
                    );
                }
            }
        }

        return dp[numItems][budget];
    }
}
