package Array;

//Problem (Stock II)\
//You are allowed to:
//Buy and sell multiple times
//But you must sell before you buy again
//Return the maximum profit.
//
//🧠 Intuition
//Whenever there is a profit opportunity, take it.
//👉 If price[i] > price[i-1], take the profit.
//
//This simulates:
//Buy before rise
//Sell at peak
//
//✅ Algorithm (Greedy)
//Traverse prices from day 1
//If prices[i] > prices[i-1]
//Add (prices[i] - prices[i-1]) to profit

public class BestTimeToBuySellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Stock II): " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
